package com.example.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
@Configuration
@PropertySource("classpath:application.yml")
public class MYSQLDataSource {
    @Value("${spring.datasource.url}")
    private String dataUrl;
    @Value("${spring.datasource.username}")
    private String user;
    @Bean
    DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(dataUrl)
                .username(user)
                .password("root")
                .build();
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
