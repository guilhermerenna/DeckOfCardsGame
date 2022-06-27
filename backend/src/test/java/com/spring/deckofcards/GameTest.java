package com.spring.deckofcards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.example.deckofcards.json.Json;
import com.fasterxml.jackson.databind.JsonNode;

import com.example.deckofcards.api.Game;

public class GameTest {
	String gameJsonSample = "{ \"gameName\": \"MikesGame\", \"id\": 123456789 }";
	String newGame = "{ \"gameName\": \"newGame\" }";
	
	@Test
	public void sampleJson_callFromJson_returnNameAndId() throws IOException {
		JsonNode node = Json.parse(gameJsonSample);
		
		Game game = Json.fromJson(node, Game.class);
		
		assertEquals(game.getGameName(), "MikesGame");
		assertEquals(game.getGameId(), 123456789);
	}
}
