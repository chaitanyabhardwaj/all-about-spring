package com.example.MyRest.service.impl;

import com.example.MyRest.dao.AnimalDao;
import com.example.MyRest.service.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;

public class BirdService implements Animal {

    private final static String NAME = "Bird";

    private int i;

    @Autowired
    private AnimalDao dao;

    public BirdService() {
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

    @Override
    public AnimalDao getAnimalDao() {
        return dao;
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
