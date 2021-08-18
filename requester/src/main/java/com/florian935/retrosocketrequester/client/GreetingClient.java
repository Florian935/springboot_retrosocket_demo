package com.florian935.retrosocketrequester.client;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.retrosocket.RSocketClient;
import reactor.core.publisher.Mono;

@RSocketClient
public interface GreetingClient {

    @MessageMapping("hello")
    Mono<String> greet();
}
