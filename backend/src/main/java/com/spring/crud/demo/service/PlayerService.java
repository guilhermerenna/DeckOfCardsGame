package com.spring.crud.demo.service;

import java.util.List;

import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.pojo.PlayerRequest;

public interface PlayerService {
	List<?> findAll();

    Player findById(int id);
    
    Player update(int id, Player player);

    void delete(int id);

	Player save(PlayerRequest playerRequest);

}
