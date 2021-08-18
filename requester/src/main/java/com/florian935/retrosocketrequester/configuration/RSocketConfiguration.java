package com.florian935.retrosocketrequester.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketConfiguration {

    @Bean
    RSocketRequester requester1(RSocketRequester.Builder builder) {

        return builder
                .tcp("localhost", 7000);
    }

    @Bean
    RSocketRequester requester2(RSocketRequester.Builder builder) {

        return builder.tcp("localhost", 7000);
    }
}
