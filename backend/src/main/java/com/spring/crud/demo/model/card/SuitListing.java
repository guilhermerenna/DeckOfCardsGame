package com.spring.crud.demo.model.card;

import java.util.ArrayList;

import lombok.Data;

@Data
public class SuitListing {
	private ArrayList<SuitListingEntry> entries = new ArrayList<SuitListingEntry>();
	private char suit;
	
	public SuitListing(char suit) {
		for(int i=1;i<=13;i++) {
			entries.add(new SuitListingEntry(i, suit));
		}
	}
	
	public void incrementCard(int card) {
		entries.get(card-1).incrementCount();
	}
	
	public void decrementCard(int card) {
		entries.get(card-1).decrementCount();
	}
	
	public void incrementAll() {
		for(SuitListingEntry e : entries) {
			e.incrementCount();
		}
	}
}
