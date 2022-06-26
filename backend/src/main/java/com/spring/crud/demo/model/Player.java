package com.spring.crud.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.crud.demo.model.card.Card;
import com.spring.crud.demo.pojo.PlayerRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Player implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int points;	
	
	@JsonIgnore
	@JsonBackReference
	@ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="game_id")
	private Game game;
	
	public Player(PlayerRequest player, Game game) {
		this.id = player.getId();
		this.name = player.getName();
		this.points = player.getPoints();
		this.game = game;
	}
	
	public void giveCard(Card card) {
		GamesSingleton.dealCardToPlayer(id, card);
	}
	
	public ArrayList<Card> getHand(int id) {
		return GamesSingleton.getHand(id);
	}
}