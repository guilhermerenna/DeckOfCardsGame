package com.deckofcards;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

// import lombok.AccessLevel; // Not needed since Getters and Setters are public
import lombok.Getter;
import lombok.Setter;

@Entity
public class Game {
	@Getter @Setter @Id private String name;
	@Getter @Setter private String shoe;
	@Getter private ArrayList<String> players;
	
	private Game() {
		//
	}
	
	private Game(String name, String shoe, ArrayList<String> players) {
		this.name = name;
		this.shoe = shoe;
		this.players = players;
	}
	
	public static Game create(String name) {
		return Game.create(name, "");
	}
	
	public static Game create(String name, String shoe) {
		return Game.create(name, shoe, new ArrayList<String>());
	}
	
	public static Game create(String name, String shoe, ArrayList<String> players) {
		return new Game(name, shoe, players);
	}
	
	public void addPlayer(String name) {
		players.add(name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.name, this.players);
	}
	
	@Override
	public String toString() {
		StringBuilder gameString = new StringBuilder();
		// gameString.append("\"name\" : '");
		gameString.append("\"" + this.name);
		gameString.append("\" : {");
		// gameString.append('\'');
		gameString.append("\"shoe\" : \"");
		gameString.append(this.shoe == null ? "null" : this.shoe);
		gameString.append("\", \"players\" : ");
		gameString.append(this.players == null ? "null" : this.players);
		gameString.append('}');
		return gameString.toString();
	}	
	
}
