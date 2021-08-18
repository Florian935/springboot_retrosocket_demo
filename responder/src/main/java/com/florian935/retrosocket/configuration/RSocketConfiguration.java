package com.florian935.retrosocket.configuration;

import org.springframework.boot.rsocket.messaging.RSocketStrategiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.codec.StringDecoder;
import org.springframework.util.MimeType;

@Configuration
public class RSocketConfiguration {

    private final String headerId = "client-id";
    private final MimeType mimeType = MimeType.valueOf("messaging/x.florian935.client-id");

    @Bean
    RSocketStrategiesCustomizer rSocketStrategiesCustomizer() {

        return strategies -> strategies
                .metadataExtractorRegistry(registry ->
                        registry.metadataToExtract(mimeType, String.class, headerId))
                .decoders(decoders -> decoders.add(StringDecoder.allMimeTypes()));
    }
}
