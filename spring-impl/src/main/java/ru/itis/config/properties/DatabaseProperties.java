package ru.itis.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DatabaseProperties {
    private final String url;
    private final String username;
    private final String password;
    private final String driverClassName;
    private final Integer poolSize;

    public DatabaseProperties(@Value("${db.url}") String url,
                              @Value("${db.username}") String username,
                              @Value("${db.password}") String password,
                              @Value("${db.driver.classname}") String driverClassName,
                              @Value("${db.hikari.max-pool-size}") String poolSize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.poolSize = Integer.valueOf(poolSize);
    }

}

