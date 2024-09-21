package com.example.cogni.monogoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonogoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonogoDbApplication.class, args);
	}

}
