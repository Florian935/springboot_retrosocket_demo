package com.florian935.retrosocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class RetrosocketApplication {

	public static void main(String[] args) {

		Hooks.onErrorDropped(error -> {});
		SpringApplication.run(RetrosocketApplication.class, args);
	}

}
