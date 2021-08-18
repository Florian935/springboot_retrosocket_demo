package com.florian935.retrosocketrequester.configuration;

import com.florian935.retrosocketrequester.client.Requester1RSocket;
import com.florian935.retrosocketrequester.client.Requester2RSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketConfiguration {

    @Bean
    @Requester1RSocket
    RSocketRequester requester1RSocket(RSocketRequester.Builder builder) {

        return builder
                .tcp("localhost", 7000);
    }

    @Bean
    @Requester2RSocket
    RSocketRequester requester2RSocket(RSocketRequester.Builder builder) {

        return builder.tcp("localhost", 7000);
    }
}
