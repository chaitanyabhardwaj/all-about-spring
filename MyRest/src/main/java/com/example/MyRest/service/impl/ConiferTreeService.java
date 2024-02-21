package com.example.MyRest.service.impl;

import com.example.MyRest.service.Plant;
import org.springframework.stereotype.Service;

@Service
public class ConiferTreeService implements Plant {

    private final static String NAME = "Conifer Tree";

    public ConiferTreeService() {}

    @Override
    public String getSpecies() {
        return NAME;
    }

}
