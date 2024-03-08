package com.example.MyRest.service;

import com.example.MyRest.dao.AnimalDao;
import com.example.MyRest.entity.AnimalEntity;
import com.example.MyRest.model.AnimalModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface Animal {

    String getBreed();

    void increaseI();

    int getI();

    AnimalDao getAnimalDao();

    default AnimalModel toModel(AnimalEntity entity) {
        if(entity == null) return null;
        return new AnimalModel(entity.getId(), entity.getBreed(), entity.getIntelligence());
    }

    default AnimalEntity toEntity(AnimalModel model) {
        if(model == null) return null;
        return new AnimalEntity(model.getId(), model.getBreed(), model.getIntelligence());
    }

    default void save(AnimalModel model) {
        getAnimalDao().save(toEntity(model));
    }

    default AnimalModel findById(int id) {
        return toModel(getAnimalDao().findById(id));
    }

    default AnimalModel findByBreed(String breed) {
        List<AnimalEntity> list1 = getAnimalDao().findByBreed(breed);
        if(list1.isEmpty()) return null;
        return toModel(list1.getFirst());
    }

    default List<AnimalModel> findAll() {
        List<AnimalEntity> list1 = getAnimalDao().findAll();
        return list1.stream().map(this::toModel).toList();
    }

    default void update(AnimalModel model) {
        getAnimalDao().update(toEntity(model));
    }

    default void updateIntelligence(BigDecimal intelligence, int id) {
        getAnimalDao().updateIntelligence(intelligence, id);
    }

    default void delete(AnimalModel model) {
        getAnimalDao().delete(toEntity(model));
    }

    default void delete(Integer id) {
        getAnimalDao().delete(id);
    }

}
