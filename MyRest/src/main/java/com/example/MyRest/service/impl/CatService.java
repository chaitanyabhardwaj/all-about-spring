package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CatService implements Animal {

    private final static String NAME = "Cat";

    private int i;

    public CatService() {
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

}
