package com.example.springcontext.controller;

import com.example.springcontext.service.Beverage;
import com.example.springcontext.service.Cake;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/*
This class is an example for Dependency Injection
through constructor
This kind of Dependency Injection is most preferred
 */

@Controller
public class OrderController {

    final private Cake cake;
    final private Beverage beverage;

    /*
        Value of Cake will depend upon the spring profile "cakeProfile"
        Beverage = Americano
        Because "thisIsAmericano" Qualifier is specified
     */
    public OrderController(Cake cake, @Qualifier("thisIsAmericano") Beverage beverage) {
        this.cake = cake;
        this.beverage = beverage;
    }

    public void printOrderDetails() {
        System.out.println("================\nOrder Details");
        System.out.println("Cake Name - " + cake.name());
        System.out.println("Cake Price - " + cake.price());
        System.out.println("Beverage Name - " + beverage.name());
        System.out.println("Beverage Price - " + beverage.price());
    }

}
