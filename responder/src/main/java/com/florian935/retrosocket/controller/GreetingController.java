package com.florian935.retrosocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class GreetingController {

    @MessageMapping("hello")
    Mono<String> hello() {

        return Mono.just("Hello World !");
    }
}
