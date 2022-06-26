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
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.pojo.PlayerRequest;
import com.spring.crud.demo.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
	@Autowired	
	private PlayerService service;
	
	@LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Player player = service.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlayerRequest playerRequest) {
        Player savedPlayer = service.save(playerRequest);
        
        UriComponentsBuilder path = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}");
        
        URI uri = path.buildAndExpand(savedPlayer.getId()).toUri();
        
        return ResponseEntity.created(uri).body(savedPlayer);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Player playerRequest) {
        Player updatedPlayer = service.update(id, playerRequest);
        return ResponseEntity.ok().body(updatedPlayer);
    }
    
    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> delete(@PathVariable int playerId) {
        service.delete(playerId);
        System.out.println("Deleted player "+playerId);
        return ResponseEntity.ok().body("Player "+playerId+" deleted successfully.");
    }  
}
