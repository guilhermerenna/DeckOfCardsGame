package com.example.deckofcards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameITold {
	@Autowired
	private TestRestTemplate gameRepository;
	
	String game1 = "{\"id\":1,\"gameName\":\"MikesGame\"}";
	
	/*@Test
	public void insertGame() throws Exception {
		Game newGame = new Game("game1",999999L);
		ResponseEntity<String> response = gameRepository.getForEntity("/games", null)
	}*/
	
	@Test
	public void getAllGames() throws Exception {
		ResponseEntity<String> response = gameRepository.getForEntity("/games/1", String.class);
		assertEquals(response.getBody(),game1);
	}
}
