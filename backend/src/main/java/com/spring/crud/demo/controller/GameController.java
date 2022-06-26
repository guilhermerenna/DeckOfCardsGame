package com.spring.crud.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.exception.EmptyShoeException;
import com.spring.crud.demo.model.Game;
import com.spring.crud.demo.model.GamesSingleton;
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.service.GameService;
import com.spring.crud.demo.service.PlayerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/games")
public class GameController {
	@Autowired private GameService service;
	@Autowired private PlayerService playerService;
	
	@LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Game game = service.findById(id);
        return ResponseEntity.ok().body(game);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Game game) {
        Game savedGame = service.save(game);
        
        UriComponentsBuilder path = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}");
        
        URI uri = path.buildAndExpand(savedGame.getId()).toUri();
        
        return ResponseEntity.created(uri).body(savedGame);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Game game) {
        Game updatedGame = service.update(id, game);
        return ResponseEntity.ok().body(updatedGame);
    }
    
    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}/newplayer/{playername}")
    public ResponseEntity<?> update(@PathVariable int id, @PathVariable String name, @RequestBody Game game) {
        Game updatedGame = service.update(id, game);
        //TODO
        return ResponseEntity.ok().body(updatedGame);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Game "+id+" deleted successfully.");
    }  
    
    @Operation(summary = "This will add a new deck to the game ID passed as a parameter")
    @LogObjectBefore
    @LogObjectAfter
    @GetMapping("/{id}/adddeck")
    public ResponseEntity<?> addDeck(@PathVariable int id) {
    	Game game = service.findById(id);
    	if(game != null) return ResponseEntity.ok().body(game.addDeck());
    	else return ResponseEntity.unprocessableEntity().body(id);
    }
    
    @LogObjectAfter
    @GetMapping("/{gameId}/players")
    public ResponseEntity<List<?>> findAllPlayers(@PathVariable int gameId) {
    	Game game = service.findById(gameId);
    	
        List<?> list = game.getPlayers();
        return ResponseEntity.ok().body(list);
    }    
    
    @Operation(summary = "This will show the cards for a specific player ID.")
    @LogObjectAfter
    @GetMapping("/{id}/playerhand/{playerid}")
    public ResponseEntity<?> findById(@PathVariable int id, @PathVariable int playerid) {
        Game game = service.findById(id);
        for (Player p : game.getPlayers())
        	if(p.getId() == playerid)
        		return ResponseEntity.ok().body(GamesSingleton.getHand(playerid));
        return ResponseEntity.badRequest().body(game);
    }
    
    @Operation(summary = "This will draw a card from the game ID and give it to PLAYERID.")
    @LogObjectAfter
    @GetMapping("/{id}/deal/{playerid}")
    public ResponseEntity<?> dealCard(@PathVariable int id, @PathVariable int playerid) {
    	try {
			return ResponseEntity.ok(GamesSingleton.dealCardFromDeckToPlayer(id, playerid));
		} catch (EmptyShoeException e1) {
			return ResponseEntity.badRequest().body("EmptyShoeException for game "+id);
		}
    }
}
