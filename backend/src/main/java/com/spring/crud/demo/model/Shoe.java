package com.spring.crud.demo.model;

import java.util.LinkedList;
import java.util.Random;

import com.spring.crud.demo.exception.EmptyShoeException;
import com.spring.crud.demo.model.card.Card;
import com.spring.crud.demo.model.card.SuitListing;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Shoe {
	private LinkedList<Card> shoe;
	
	// Tracking of individual cards
	private SuitListing listingsHearts;
	private SuitListing listingsSpades;
	private SuitListing listingsClubs;
	private SuitListing listingsDiamonds;
	
	// Counts for each suit
	private int countSpades;
	private int countHearts;
	private int countClubs;
	private int countDiamonds;
	
	public Shoe() {
		listingsHearts = new SuitListing('h');
		listingsSpades = new SuitListing('s');
		listingsClubs = new SuitListing('c');
		listingsDiamonds = new SuitListing('d');
		countSpades = 0;
		countHearts = 0;
		countClubs = 0;
		countDiamonds = 0;
	}
	
	public SuitListing getSuitListing(char suit) {
		switch(suit) {
		case 'h':
			return listingsHearts;
		case 's':
			return listingsSpades;
		case 'c':
			return listingsClubs;
		case 'd':
			return listingsDiamonds;
		}
		return null;
	}
	
	protected int addNewDeck() {
		if(shoe == null) shoe = new LinkedList<Card>();
		LinkedList<Card> newDeck = new LinkedList<Card>();
		// Hearts
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('h').cvalue(i).build());
		countHearts+=13;
		listingsHearts.incrementAll();
		
		// Spades
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('s').cvalue(i).build());
		countSpades+=13;
		listingsSpades.incrementAll();
		
		// Clubs
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('c').cvalue(i).build());
		countClubs+=13;
		listingsClubs.incrementAll();
		
		// Diamonds
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('d').cvalue(i).build());
		countDiamonds+=13;
		listingsDiamonds.incrementAll();
		
		shoe.addAll(newDeck);
		return shoe.size();
	}
	
	protected Card drawCard() throws EmptyShoeException {
		if(shoe == null) shoe = new LinkedList<Card>();
		
		if(shoe.isEmpty()) throw new EmptyShoeException();
		Card drawnCard = shoe.pop();
		return accountDrawnCard(drawnCard);
	}
	
	public Card accountDrawnCard(Card drawnCard) {
		switch (drawnCard.getSuit()) {
		case 'h':
			countHearts--;
			listingsHearts.decrementCard(drawnCard.getCvalue());
			break;
		case 's':
			countSpades--;
			listingsSpades.decrementCard(drawnCard.getCvalue());
			break;
		case 'c':
			countClubs--;
			listingsClubs.decrementCard(drawnCard.getCvalue());
			break;
		case 'd':
			countDiamonds--;
			listingsDiamonds.decrementCard(drawnCard.getCvalue());
			break;
		}
		return drawnCard;
	}
		
	public int getSize() {
		return shoe.size();
	}
	
	public int getCountSuit(String suit) {
		switch(suit.toLowerCase().charAt(0)) {
		case 's':
			return countSpades;
		case 'h':
			return countHearts;
		case 'd':
			return countDiamonds;
		case 'c':
			return countClubs;
		}
		return 0;
	}

	public void shuffle() {
		LinkedList<Card> shuffledShoe = new LinkedList<Card>();
		Random rand = new Random();
		while(!shoe.isEmpty()) {
			shuffledShoe.add(shoe.remove(rand.nextInt(shoe.size()))); 
		}
		shoe = shuffledShoe;
	}	
}
