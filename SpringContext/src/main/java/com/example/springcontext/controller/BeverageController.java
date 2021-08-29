package com.example.springcontext.controller;

import com.example.springcontext.service.Beverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
This class is an example for Dependency Injection
through property
This kind of Dependency Injection is least preferred
 */

@Controller
public class BeverageController {

    /*
        Beverage will be Espresso
        Because Espresso has "Primary" annotation
     */
    @Autowired
    public Beverage beverage;

    public void printBeverageDetails() {
        System.out.println("================\nBeverage Details");
        System.out.println("Name - " + beverage.name());
        System.out.println("Price - " + beverage.price());
    }

}
