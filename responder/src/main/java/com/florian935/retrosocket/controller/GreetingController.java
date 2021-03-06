package com.florian935.retrosocket.controller;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Map;

@Controller
public class GreetingController {

    @MessageMapping("hello.{name}")
    Mono<String> hello(@Header("client-id") String clientId,
                       @DestinationVariable String name,
                       @Payload Integer age,
                       @Headers Map<String, Object> headers) {

        headers.forEach((k, v) -> System.out.println(k + " = " + v));

        final String response = String
                .format("Hello %s, your client id is: %s, your age: %d",
                        name,
                        clientId,
                        age
                );

        return Mono.just(response);
    }
}
