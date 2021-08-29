package com.example.springcontext.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"chocolateCakeProfile", "default"})
@Service
public class Chocolate implements Cake {

    @Override
    public String name() {
        return "Chocolate Cake";
    }

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public void eat() {
        System.out.println("Ate chocolate cake!");
    }

}
