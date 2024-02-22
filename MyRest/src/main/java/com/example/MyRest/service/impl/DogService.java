package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class DogService implements Animal {

    private final static String NAME = "Dog";

    private int i;

    public DogService() {
        System.out.println("In constructor of " + getClass().getSimpleName());
    }

    @Override
    public String getBreed() { return NAME; }

    @Override
    public void increaseI() {
        i++;
    }

    @Override
    public int getI() {
        return i;
    }

}
