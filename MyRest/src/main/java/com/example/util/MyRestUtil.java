package com.example.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyRestUtil {

    final private static String JUMP_STR = "A %s jumps over a %s";

    public MyRestUtil() {
        System.out.println("In constructor of " + getClass().getSimpleName());
    }
    public String animalFarmHelper(String animal1, String animal2) {
        if (animal1.length() < animal2.length()) return JUMP_STR.formatted(animal1, animal2);
        return JUMP_STR.formatted(animal2, animal1);
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + getClass().getSimpleName() + " has been constructed!");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Bean " + getClass().getSimpleName() + " is being destroyed!");
    }

}
