package com.spring.crud.demo.service;

import java.util.List;

import com.spring.crud.demo.model.Game;

public interface GameService {
	List<?> findAll();

    Game findById(int id);

    Game save(Game game);

	Game update(int id, Game game);

    void delete(int id);

}
