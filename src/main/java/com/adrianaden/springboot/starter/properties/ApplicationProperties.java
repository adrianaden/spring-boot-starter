package com.adrianaden.springboot.starter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix="application")
public class ApplicationProperties {

    private Jwt jwt;

    @Setter
    @Getter
    public static class Jwt {

        private String secret;
        private Long expiration = 120L;
    }
}
