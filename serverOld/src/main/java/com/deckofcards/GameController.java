package com.deckofcards;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class GameController {
	private GameController() {
		//
	}
	
	// Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/games")
	  String all() {
	    return Games.toJson();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/games")
	  Game newGame(@RequestBody Game newGame) {
	    return Games.addGame(newGame);
	  }

	  // Single item
	  
	  @GetMapping("/games/{name}")
	  Game one(@PathVariable String name) {	    
	    return Games.findByName(name);
	  }

	  /*
	  @PutMapping("/games/{name}")
	  Game replaceEmployee(@RequestBody Game newGame, @PathVariable String name) {
	    
	    return Games.findByName(name)
	      .map(employee -> {
	        employee.setName(newEmployee.getName());
	        employee.setRole(newEmployee.getRole());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return repository.save(newEmployee);
	      });
	  }

	  @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable String name) {
	    Games.deleteByName(name);
	  }*/
}
