package com.spring.crud.demo;

import com.spring.crud.demo.model.Game;
import com.spring.crud.demo.repository.GameRepository;
import com.spring.crud.demo.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class DeckOfCardsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckOfCardsBackendApplication.class, args);
	}
	
	@Autowired
	private GameRepository gameRepository;

	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Game> games = gameRepository.findAll();
			if (games.isEmpty()) {
				log.info("Inserting sample games into DB...");
				gameRepository.saveAll(HelperUtil.gameSupplier.get());
			} else {
				log.info("No need to insert Games, as there were already "+ games.size());
				log.info("Games stored into DB : {}", games);
			}
		};
	}

}
