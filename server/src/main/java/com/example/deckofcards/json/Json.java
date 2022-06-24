package com.example.deckofcards.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		// TODO: Config
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String src) throws IOException {
		return objectMapper.readTree(src);
	}

	public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(node, clazz);
	}
}
