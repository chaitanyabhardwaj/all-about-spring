package com.example.MyRest.service.impl;

import com.example.MyRest.dao.AnimalDao;
import com.example.MyRest.service.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class DogService implements Animal {

    private final static String NAME = "Dog";

    private int i;

    @Autowired
    private AnimalDao dao;

    public DogService() {
        System.out.println("In constructor of " + getClass().getSimpleName());
    }

    @Override
    public String getBreed() { return NAME; }

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
