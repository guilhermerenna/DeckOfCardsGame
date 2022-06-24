package com.example.deckofcards.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GameRestController {
	
	@GetMapping("/games")
	Collection<Game> games() {
		return gameRepository.findAll();
	}
	
	@GetMapping("/games/{id}")
	Game one(@PathVariable Long id) throws Exception {
		return gameRepository.findById(id)
				.orElseThrow(() -> new GameNotFoundException(id));
	}
	
	@PostMapping("/games")
	Game newGame(@RequestBody Game newGame) {
		return gameRepository.save(newGame);
	}
	
	// To consider: do we want to let games to be updated?
	@PutMapping("/games/{id}")
	  Game replaceGame(@RequestBody Game newGame, @PathVariable Long id) {
	    
	    return gameRepository.findById(id)
	      .map(game -> {
	        game.setGameName(newGame.getGameName());
	        return gameRepository.save(game);
	      })
	      .orElseGet(() -> {
	        newGame.setId(id);
	        return gameRepository.save(newGame);
	      });
	  }
	
	@Autowired
	GameRepository gameRepository;
}



@Component
class GameCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		for(Game g : this.gameRepository.findAll()) {
			System.out.println(g.toString());
		}
		
	}
	
	@Autowired GameRepository gameRepository;
	
}

interface GameRepository extends JpaRepository<Game, Long> {
	Collection<Game> findByGameName(String gameName);
}

class GameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2834596659602052484L;

	GameNotFoundException(Long id) {
	    super("Could not find game " + id);
	  }
	}