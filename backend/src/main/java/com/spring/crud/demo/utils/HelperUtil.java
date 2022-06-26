package com.spring.crud.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.spring.crud.demo.model.Game;
import com.spring.crud.demo.model.Player;

public class HelperUtil {

    private HelperUtil() {
    }
    
    public static Supplier<List<Game>> gameSupplier = () -> {
    	
    	Game g1 = Game.builder().name("Mikes Game2").build();
    	
    	Player p1 = Player.builder().name("Guilherme").points(0).game(g1).build();
    	Player p2 = Player.builder().name("Adriana").points(0).game(g1).build();
    	
    	List<Player> playersG1 = new ArrayList<Player>();
    	playersG1.add(p1);
    	playersG1.add(p2);
    	playersG1.add(Player.builder().name("Mike").points(0).game(g1).build());
    	g1.setPlayers(playersG1);
    	
    	List<Game> games = Arrays.asList( 
    			Game.builder().name("GameOfThrones").build(),
    			g1,    		
    			Game.builder().name("Gang of Four").build());
    	
    	return games;
    	};
}
