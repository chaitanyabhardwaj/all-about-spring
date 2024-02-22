package com.example.MyRest.service.impl;

import com.example.MyRest.service.Plant;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class ConiferTreeService implements Plant {

    private final static String NAME = "Conifer Tree";

    public ConiferTreeService() {
        System.out.println("In constructor of " + getClass().getSimpleName());
    }

    @Override
    public String getSpecies() {
        return NAME;
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
