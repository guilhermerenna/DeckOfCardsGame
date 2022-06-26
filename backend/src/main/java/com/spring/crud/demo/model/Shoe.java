package com.spring.crud.demo.model;

import java.util.LinkedList;

import com.spring.crud.demo.exception.EmptyShoeException;
import com.spring.crud.demo.model.card.Card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shoe {
	LinkedList<Card> shoe;
	int countSpades = 0;
	int countHearts = 0;
	int countClubs = 0;
	int countDiamonds = 0;
	
	protected int addNewDeck() {
		if(shoe == null) shoe = new LinkedList<Card>();
		LinkedList<Card> newDeck = new LinkedList<Card>();
		// Hearts
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('h').cvalue(i).build());
		countHearts+=13;
		
		// Spades
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('s').cvalue(i).build());
		countSpades+=13;
		
		// Clubs
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('c').cvalue(i).build());
		countClubs+=13;
		
		// Diamonds
		for(int i=1;i<=13;i++) newDeck.push(Card.builder().suit('d').cvalue(i).build());
		countDiamonds+=13;
		
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
			break;
		case 's':
			countSpades--;
			break;
		case 'c':
			countClubs--;
			break;
		case 'd':
			countDiamonds--;
			break;
		}
		return drawnCard;
	}
		
	public int getSize() {
		return shoe.size();
	}
}
