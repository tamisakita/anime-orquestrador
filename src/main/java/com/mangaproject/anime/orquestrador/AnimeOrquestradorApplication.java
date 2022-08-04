package com.mangaproject.anime.orquestrador;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit
@SpringBootApplication
public class AnimeOrquestradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeOrquestradorApplication.class, args);
	}

}
