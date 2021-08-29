package com.example.springcontext.controller;

import com.example.springcontext.service.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/*
This class is an example for Dependency Injection
through setter
This kind of Dependency Injection is better than
property Injection, but should still be avoided
 */

@Controller
public class CakeController {

    private Cake cake;

    public Cake getCake() {
        return cake;
    }

    /*
        Value of Cake will depend upon the spring profile "cakeProfile"
     */
    @Autowired
    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public void printCakeDetails() {
        System.out.println("================\nCake Details");
        System.out.println("Name - " + cake.name());
        System.out.println("Price - " + cake.price());
    }

}
