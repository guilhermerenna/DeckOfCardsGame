package com.spring.crud.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
//	@JsonManagedReference
//	@OneToMany( fetch = FetchType.LAZY, mappedBy = "game", 
//		cascade = {
//			CascadeType.MERGE,
//			CascadeType.PERSIST,
//			CascadeType.REMOVE
//	})
//	private List<Card> shoe;
}
