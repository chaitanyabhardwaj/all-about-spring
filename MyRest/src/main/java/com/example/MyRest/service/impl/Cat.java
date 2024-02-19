package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    final private String NAME;

    public Cat() {
        NAME = "Cat";
    }
    @Override
    public String getName() {
        return NAME;
    }

}
