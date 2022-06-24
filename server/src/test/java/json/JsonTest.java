package json;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.example.deckofcards.json.Json;
import com.fasterxml.jackson.databind.JsonNode;

class JsonTest {
	String simpleTestCaseJsonSource = "{ \"title\": \"MikesGame\", \"id\": 123456789 }";
	
	@Test
	public void parse() throws IOException {
		JsonNode node = Json.parse(simpleTestCaseJsonSource);
		
		String title = node.get("title").asText();
		
		assertEquals(title, "MikesGame");
	}
	
	@Test
	public void fromJson() throws IOException {
		JsonNode node = Json.parse(simpleTestCaseJsonSource);
		
		DummyJsonPOJO pojo = Json.fromJson(node, DummyJsonPOJO.class);
		
		assertEquals(pojo.getTitle(), "MikesGame");
		assertEquals(pojo.getId(), 123456789);
	}
}
