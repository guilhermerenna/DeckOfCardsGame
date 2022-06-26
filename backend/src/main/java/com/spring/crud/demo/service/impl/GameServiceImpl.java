package com.spring.crud.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.spring.crud.demo.model.Game;
import com.spring.crud.demo.repository.GameRepository;
import com.spring.crud.demo.service.GameService;

@Service
public class GameServiceImpl implements GameService {	
	@Autowired
	private GameRepository repository;

	@Override
	public List<Game> findAll() {
		return repository.findAll();
	}

	@Override
	public Game findById(int id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find a game with ID : " + id));
	}

	@Override
	public Game save(Game game) {
		return repository.save(game);
	}

	@Override
	public Game update(int id, Game game) {
		repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find a game with ID : " + id));
        
    	game.setId(id);
    	return repository.save(game);
	}

	@Override
	public void delete(int id) {
		repository.findById(id).ifPresent(Game -> repository.delete(Game));		
	}
}
