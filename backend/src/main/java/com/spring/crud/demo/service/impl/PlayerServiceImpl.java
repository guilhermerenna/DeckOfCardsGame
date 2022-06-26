package com.spring.crud.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.spring.crud.demo.model.Game;
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.pojo.PlayerRequest;
import com.spring.crud.demo.repository.GameRepository;
import com.spring.crud.demo.repository.PlayerRepository;
import com.spring.crud.demo.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired private PlayerRepository repository;
	@Autowired private GameRepository gameRepository;

	@Override
	public List<Player> findAll() {
		return repository.findAll();
	}

	@Override
	public Player findById(int id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find a player with ID : " + id));
	}

	@Override
	public Player save(PlayerRequest playerRequest) {
		Game game = gameRepository.findById(playerRequest.getGame_id()).orElseThrow(() -> new NotFoundException("Could not find a game with ID : " + playerRequest.getGame_id()));
		Player player = new Player(playerRequest, game);
		
		return repository.save(player);
	}

	@Override
	public Player update(int id, Player player) {
		repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find a player with ID : " + id));
        
    	player.setId(id);
    	return repository.save(player);
	}

	@Override
	public void delete(int id) {
		repository.findById(id).ifPresent(Player -> repository.delete(Player));			
	}

}
