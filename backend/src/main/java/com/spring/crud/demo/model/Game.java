package com.spring.crud.demo.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Game implements Serializable {
	private static final long serialVersionUID = -7812450148177467986L;
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@JsonManagedReference
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "game", 
		cascade = {
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REMOVE
	})
	private List<Player> players;
	
	public int addDeck() {
		return GamesSingleton.addNewDeck(this.id);
	}
	
	public List<Player> getPlayers() {
		Collections.sort(this.players, new PlayerComparator());
		return this.players;
	}
}

class PlayerComparator implements Comparator<Player> {
	@Override
	public int compare(Player p1, Player p2) {
		return p2.getPoints() - p1.getPoints();
	}
}
