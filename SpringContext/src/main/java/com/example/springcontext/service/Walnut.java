package com.example.springcontext.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("walnutCakeProfile")
@Service
public class Walnut implements Cake {

    @Override
    public String name() {
        return "Walnut Cake";
    }

    @Override
    public float price() {
        return 27.5f;
    }

    @Override
    public void eat() {
        System.out.println("Ate walnut cake");
    }
}
