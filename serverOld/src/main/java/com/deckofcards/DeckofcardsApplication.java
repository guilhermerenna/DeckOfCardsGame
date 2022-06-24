package com.deckofcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeckofcardsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DeckofcardsApplication.class, args);
		Games.addGame(Game.create("g1"));
		Games.addGame(Game.create("g2"));
		
		System.out.println(Games.toJson());
	}

}
