package com.example.deckofcards.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Game {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long id;
	@Getter @Setter private String gameName;
	
	public Game(String gameName) {
		super();
		this.gameName = gameName;
	}
	
	public Game(String gameName, Long id) {
		super();
		this.gameName = gameName;
		this.id = id;
	}
	
	public Game() {		
	}	
}
