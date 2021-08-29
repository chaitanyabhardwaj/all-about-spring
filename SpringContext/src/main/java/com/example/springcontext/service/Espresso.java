package com.example.springcontext.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class Espresso implements Beverage {

    @Override
    public String name() {
        return "Espresso";
    }

    @Override
    public float price() {
        return 7.0f;
    }

    @Override
    public void drink() {
        System.out.println("Drank Espresso!");
    }

}
