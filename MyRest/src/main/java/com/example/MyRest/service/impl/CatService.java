package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CatService implements Animal {

    private final static String NAME = "Cat";

    public CatService() {}
    @Override
    public String getBreed() {
        return NAME;
    }

}
