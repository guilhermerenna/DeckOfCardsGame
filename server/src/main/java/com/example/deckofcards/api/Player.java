package com.example.deckofcards.api;

import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Player {
	@Id 
	@Getter private Long id;
	
	@ManyToOne
	@JoinColumn(name = "gameId")
	@Getter @Setter private Game game;
	
	@Getter @Setter String name;
	@Getter @Setter int points;
	@Getter @Setter LinkedList<Card> cards;
	
	public Player(String name) {
		this.name = name;
		this.points = 0;
	}
	
	public Player(String name, Game game) {
		this.name = name;
		this.points = 0;
		this.game = game;
	}
	
	public Player() {
	}
	
	public void giveCard(char suit, int value) {
		giveCard(new Card(suit,value));
	}
	
	public void giveCard(Card card) {
		if(cards == null) cards = new LinkedList<Card>();
		cards.add(card);
	}
}
