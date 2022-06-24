package com.example.deckofcards;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.example.deckofcards.api.Game;
import com.example.deckofcards.json.Json;
import com.fasterxml.jackson.databind.JsonNode;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameIT {

	@Autowired
	private TestRestTemplate gameRepository;
	
	String game1 = "{\"id\":6,\"gameName\":\"MikesGame\"}";
	Game newGame = new Game("myNewGame");
	
	/*@Test
	public void insertGame() throws Exception {
		Game newGame = new Game("game1",999999L);
		ResponseEntity<String> response = gameRepository.getForEntity("/games", null)
	}*/
	
	@Test
	public void getGame1() throws Exception {
		ResponseEntity<String> response = gameRepository.getForEntity("/games/1", String.class);
		assertEquals(response.getBody(),game1);
	}
	
	@Test void postGame() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<Game> request = new HttpEntity<>(newGame, headers);
		
		ResponseEntity<String> response = gameRepository.postForEntity("/games", newGame, String.class);
		
		System.out.println(response);
		assertTrue(response.getStatusCodeValue() == 200);
		assertEquals(Json.parse(response.getBody()).get("gameName").asText(),newGame.getGameName());
	}

}
