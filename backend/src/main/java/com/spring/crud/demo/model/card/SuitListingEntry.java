package com.spring.crud.demo.model.card;

import lombok.Data;

@Data
public class SuitListingEntry {
	private char suit;
	private int card;
	private int count;
	
	public SuitListingEntry(int card, char suit) {
		this.card = card;
		this.suit = suit;
		count = 0;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public void decrementCount() {
		count--;
	}
}
