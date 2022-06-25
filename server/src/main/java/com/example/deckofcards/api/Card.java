package com.example.deckofcards.api;

import lombok.Getter;
import lombok.Setter;

public class Card {
	@Getter @Setter char suit;
	@Getter @Setter int value;
	
	public Card(char suit, int value) {
		this.suit = suit;
		this.value = value;
	}
}
