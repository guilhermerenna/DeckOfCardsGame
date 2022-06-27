package com.spring.crud.demo.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.crud.demo.exception.EmptyShoeException;
import com.spring.crud.demo.model.card.Card;
import com.spring.crud.demo.model.card.SuitListing;

public class GamesSingleton {
	private static HashMap<Integer,Shoe> shoes = new HashMap<Integer,Shoe>();
	private static HashMap<Integer,ArrayList<Card>> hands = new HashMap<Integer,ArrayList<Card>>();
	
	public static Shoe getShoe(int gameId) {
		if(shoes.get(gameId) == null) 
			shoes.put(gameId, new Shoe()); 
		return shoes.get(gameId);
	}
	
	public static int shuffle(int gameId) {
		shoes.get(gameId).shuffle();
		return shoes.get(gameId).getSize();
	}
	
	public static ArrayList<Card> getHand(int playerId) {
		if(hands.get(playerId) == null)
			hands.put(playerId, new ArrayList<Card>());
		return hands.get(playerId);
	}
	
	public static void deleteHand(int playerId) {
		//TODO: update stats
		hands.remove(playerId);
	}
	
	public static void dealCardToPlayer(int playerId, Card card) {
		getHand(playerId).add(card);
	}
	
	
	public static int addNewDeck(int gameId) {
		return getShoe(gameId).addNewDeck();
	}
	
	public static void dealCardFromDeckToPlayer(int gameId, Player player) throws EmptyShoeException {
		player.giveCard(getShoe(gameId).drawCard());
	}
	
	public static Card dealCardFromDeckToPlayer(int gameId, int playerid) throws EmptyShoeException {
		if(hands.get(playerid) == null) hands.put(playerid, new ArrayList<Card>());
		Card drawnCard = getShoe(gameId).drawCard();
		hands.get(playerid).add(drawnCard);
		// return drawnCard;
		return drawnCard;
	}
	
	public static SuitListing getSuitListing(int gameId, char suit) {
		return getShoe(gameId).getSuitListing(suit); 
	}

	public static Card drawCard(int gameId) throws EmptyShoeException {
		return getShoe(gameId).drawCard();
	}
	
	public static int getShoeSize(int gameId) {
		return getShoe(gameId) != null ? shoes.get(gameId).getSize() : 0;
	}
}
