package com.example.deckofcards.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PlayerRestController {	
	@GetMapping("/players")
	Collection<Player> players() {
		return playerRepository.findAll();
	}
	
	@GetMapping("/players/{name}")
	Player one(@PathVariable String name) throws Exception {
		return playerRepository.findById(name)
				.orElseThrow(() -> new PlayerNotFoundException(name));
	}
	
	@PostMapping("/players")
	Player newPlayer(@RequestBody Player newPlayer) {
		return playerRepository.save(newPlayer);
	}
	
	// To consider: do we want to let players to be updated?
	@PutMapping("/players/{name}")
	  Player replacePlayer(@RequestBody Player newPlayer, @PathVariable String name) {
	    
	    return playerRepository.findById(name)
	      .map(player -> {
	        player.setName(newPlayer.getName());
	        player.setPoints(newPlayer.getPoints());
	        player.setCards(newPlayer.getCards());
	        return playerRepository.save(player);
	      })
	      .orElseGet(() -> {
	        newPlayer.setName(name);
	        return playerRepository.save(newPlayer);
	      });
	  }
	
	@DeleteMapping("/players/{name}")
	void deletePlayer(@PathVariable String name) {
		playerRepository.deleteById(name);
	}
	
	@Autowired
	PlayerRepository playerRepository;
}



@Component
class PlayerCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		for(Player p : this.playerRepository.findAll()) {
			System.out.println(p.toString());
		}
		
	}
	
	@Autowired PlayerRepository playerRepository;
	
}

interface PlayerRepository extends JpaRepository<Player, String> {
	Collection<Player> findByName(String name);
}

class PlayerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7563270698746355191L;

	PlayerNotFoundException(String name) {
	    super("Could not find player " + name);
	  }
	}