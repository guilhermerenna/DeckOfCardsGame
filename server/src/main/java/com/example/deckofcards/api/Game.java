package com.example.deckofcards.api;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Game {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Long gameId;
	@Getter @Setter private String gameName;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="gameId")
	@Getter @Setter private Shoe gameShoe;
	
	@OneToMany(mappedBy = "game")
	@ElementCollection
	@Getter @Setter private List<Player> players;
	
	public Game(String gameName) {
		super();
		this.gameName = gameName;
	}
	
	public Game(String gameName, Long id) {
		super();
		this.gameName = gameName;
		this.gameId = id;
	}
	
	public void addDeck(LinkedList<Card> deck) {
		if(gameShoe == null) gameShoe = new Shoe(gameId);
		gameShoe.addDeck(deck);
	}
	
	public int newPlayer(String name) {
		if(players == null) {
			players = new ArrayList<Player>();
			System.out.println("initialized list");
		} else {
			System.out.println("list already existed");
		} 
		players.add(new Player(name, this));
		return 200;
	}
	
	private Player findPlayer(String name) {
		for(int i=0;i<players.size();i++) {
			if(players.get(i).getName().equals(name)) return players.get(i);
		}
		return null;
	}
	
	public void dealCardToPlayer(String name) throws PlayerNotFoundException {
		try {
			findPlayer(name).giveCard(gameShoe.dealCard());
		} catch (RuntimeException e) {
			throw new PlayerNotFoundException(name);
		}
	}
	
	public Game() {		
	}	
}
