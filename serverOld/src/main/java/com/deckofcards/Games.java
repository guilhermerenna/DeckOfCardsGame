package com.deckofcards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Games {
	private static HashMap<String, Game> games;
	
	public static Game addGame(Game game) {
		if(games == null) {
			games = new HashMap<String,Game>();
		}
		games.put(game.getName(), game);		
		return game;
	}
	
	public static HashMap<String,Game> getGames() {		
		addGame(Game.create("g1"));
		return games;
	}
	
	public static Game findByName(String name) {
		return games.get(name);
	}
	
	public static String toJson() {
		StringBuilder gamesToString = new StringBuilder("{");
		
		Object[] keySet = games.keySet().toArray();
		
		for(int i=0;i<keySet.length; i++) {
			gamesToString.append(games.get(keySet[i]).toString());
			if((i+1)<keySet.length) gamesToString.append(",");
		}
		gamesToString.append("}");
		
		return gamesToString.toString();
	}
}
