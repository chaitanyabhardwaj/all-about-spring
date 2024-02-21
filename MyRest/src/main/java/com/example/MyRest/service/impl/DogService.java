package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import org.springframework.stereotype.Service;

@Service
public class DogService implements Animal {

    private final static String NAME = "Dog";
    public DogService() {}

    @Override
    public String getBreed() { return NAME; }

}
