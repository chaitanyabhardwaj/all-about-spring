package com.example.MyRest.dao;

import com.example.MyRest.entity.AnimalEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AnimalDao {

    private EntityManager entityManager;

    public AnimalDao(EntityManager manager) {
        this.entityManager = manager;
    }

    @Transactional
    public void save(AnimalEntity animalEntity) {
        entityManager.persist(animalEntity);
    }

}
