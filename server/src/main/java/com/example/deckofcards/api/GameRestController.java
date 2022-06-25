package com.example.deckofcards.api;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

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
class GameRestController {
	
	@GetMapping("/http-servlet-response")
	public String usingHttpServletResponse(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		return "teste";
	}
	
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
	
	@PostMapping("/games/{id}/deal/{name}")
	int dealCard(@PathVariable Long id, @PathVariable String name) throws Exception {
		Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
		try {
			game.dealCardToPlayer(name);
		} catch  (PlayerNotFoundException e) {
			return 404;
		}
		return 200;
	}
	
	@PostMapping("/games/{id}/join/{name}")
	int newPlayer(@PathVariable Long id, @PathVariable String name) {
		Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
		return game.newPlayer(name);
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
	        newGame.setGameId(id);
	        return gameRepository.save(newGame);
	      });
	  }
	
	@DeleteMapping("/games/{id}")
	void deleteGame(@PathVariable Long id) {
		gameRepository.deleteById(id);
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