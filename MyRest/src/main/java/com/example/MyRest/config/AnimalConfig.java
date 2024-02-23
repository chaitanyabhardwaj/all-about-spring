package com.example.MyRest.config;

import com.example.MyRest.service.Animal;
import com.example.MyRest.service.impl.BirdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean
    public Animal birdService() {
        return new BirdService();
    }

}
