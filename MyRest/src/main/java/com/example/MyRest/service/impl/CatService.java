package com.example.MyRest.service.impl;

import com.example.MyRest.service.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CatService implements Animal {

    private final static String NAME = "Cat";

    private int i;

    public CatService() {
        System.out.println("In constructor of " + getClass().getSimpleName());
        i = 0;
    }
    @Override
    public String getBreed() {
        return NAME;
    }

    @Override
    public void increaseI() {
        i++;
    }

    @Override
    public int getI() {
        return i;
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + getClass().getSimpleName() + " has been constructed!");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Bean " + getClass().getSimpleName() + " is being destroyed!");
    }

}
