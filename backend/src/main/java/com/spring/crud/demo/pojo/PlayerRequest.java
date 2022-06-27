package com.spring.crud.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlayerRequest {
	
	private int id;
	private String name;
	private int points;
	private int game_id;
}
