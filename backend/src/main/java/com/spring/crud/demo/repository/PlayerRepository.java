package com.spring.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.demo.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
