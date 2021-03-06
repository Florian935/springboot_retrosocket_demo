package com.florian935.retrosocketrequester.client;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retrosocket.RSocketClient;
import reactor.core.publisher.Mono;

@RSocketClient
@Requester1RSocket
public interface GreetingClient {

    @MessageMapping("hello.{name}")
    Mono<String> greet(@Header("messaging/x.florian935.client-id") String clientId,
                       @DestinationVariable String name,
                       @Payload Integer age);
}
