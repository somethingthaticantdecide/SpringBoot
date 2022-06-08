package edu.school21.cinema.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaDataConfig {
    @Value("${uploadPath}")
    private String path;


    @Bean
    public String uploadPath() {
        return path;
    }
}
