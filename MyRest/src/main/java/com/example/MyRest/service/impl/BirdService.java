package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BirdService implements Animal {

    private final static String NAME = "Bird";

    private int i;

    public BirdService() {
        System.out.println("In constructor of " + getClass().getSimpleName());
        i = 0;
    }
    @Override
    public String getBreed() {
        return NAME;
    }

    @Override
    public void increaseI() {
        i++;
    }

    @Override
    public int getI() {
        return i;
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
