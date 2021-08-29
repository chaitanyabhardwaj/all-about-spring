package com.example.springcontext;

import com.example.springcontext.controller.BeverageController;
import com.example.springcontext.controller.CakeController;
import com.example.springcontext.controller.OrderController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringContextApplication {

    public static void main(String[] args) {
        //Got the application context
        ApplicationContext context = SpringApplication.run(SpringContextApplication.class, args);
        //Get the controllers from application context
        CakeController cakeController = (CakeController) context.getBean("cakeController");
        BeverageController beverageController = (BeverageController) context.getBean("beverageController");
        OrderController orderController = (OrderController) context.getBean("orderController");
        //Get a single cake
        //Will get walnut since "walnutCakeProfile" is active in applications.properties
        //Turn Off the "walnutCakeProfile" to get "Chocolate Cake"
        cakeController.printCakeDetails();
        //Get a single beverage
        //Will get espresso since espresso has the "Primary" annotation
        beverageController.printBeverageDetails();
        //Get a complete order
        //Will get americano beverage since it's specified by the Qualifier
        //Will get walnut since "walnutCakeProfile" is active in applications.properties
        //Turn Off the "walnutCakeProfile" to get "Chocolate Cake"
        orderController.printOrderDetails();
    }

}
