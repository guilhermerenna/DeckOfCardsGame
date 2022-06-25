package com.example.deckofcards.api;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Shoe {
	@Id @Getter @Setter Long gameId;
	@Getter @Setter LinkedList<Card> shoe;
	
	public Shoe(Long id) {
		this.gameId = id;
	}
	
	public Card dealCard() {
		if(shoe == null) shoe = new LinkedList<Card>();
		return shoe.poll(); 
	}
	
	public void addDeck(LinkedList<Card> deck) {
		shoe.addAll(deck);
	}
}

class EmptyShoeException extends Exception {
	private static final long serialVersionUID = -3897433684094024750L;
}
