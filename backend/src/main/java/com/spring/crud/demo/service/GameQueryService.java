package com.spring.crud.demo.service;

import java.util.List;

import com.spring.crud.demo.model.Player;


public interface GameQueryService {
	
	List<Player> getAll();

	List<Player> getPlayerByName(String name);

}
