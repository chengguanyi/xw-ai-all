package com.xuanwu.ai.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(prefix = CorsProperties.CORS_PREFIX)
public class CorsProperties extends CorsConfiguration {

    public static final String CORS_PREFIX = "spring.http.cors";
}
