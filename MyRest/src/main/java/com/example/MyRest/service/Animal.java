package com.example.MyRest.service;

import com.example.MyRest.dao.AnimalDao;
import com.example.MyRest.entity.AnimalEntity;
import com.example.MyRest.model.AnimalModel;
import org.springframework.stereotype.Component;

@Component
public interface Animal {

    String getBreed();

    void increaseI();

    int getI();

    AnimalDao getAnimalDao();

    default void save(AnimalModel model) {
        AnimalEntity entity = new AnimalEntity();
        entity.setBreed(model.getBreed());
        entity.setIntelligence(model.getIntelligence());
        getAnimalDao().save(entity);
    }

}
