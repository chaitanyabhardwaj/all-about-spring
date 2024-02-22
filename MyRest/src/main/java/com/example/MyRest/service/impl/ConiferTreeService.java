package com.example.MyRest.service.impl;

import com.example.MyRest.service.Plant;
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

}
