package com.florian935.retrosocketrequester;

import com.florian935.retrosocketrequester.client.GreetingClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.retrosocket.EnableRSocketClients;
import reactor.core.publisher.Mono;

import java.util.UUID;

@SpringBootApplication
@EnableRSocketClients
public class RetrosocketRequesterApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RetrosocketRequesterApplication.class, args);
		System.in.read();
	}

	@Bean
	ApplicationRunner runner(GreetingClient greetingClient) {

		return event -> {
			final Mono<String> reply = greetingClient
					.greet(UUID.randomUUID().toString(), "toto", 26);

			reply.subscribe(System.out::println);
		};
	}
}
