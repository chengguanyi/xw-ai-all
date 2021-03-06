package com.xuanwu.ai.druid;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class DruidDataSourceProperties {

    // jdbc
    private String driverClassName;
    private String url;
    private String username;
    private String password;

}
