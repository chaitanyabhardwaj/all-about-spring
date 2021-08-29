package com.example.springcontext.service;

import org.springframework.stereotype.Service;

@Service("thisIsAmericano")
public class Americano implements Beverage {

    @Override
    public String name() {
        return "Americano";
    }

    @Override
    public float price() {
        return 5.10f;
    }

    @Override
    public void drink() {
        System.out.println("Drank Americano!");
    }

}
