package com.example.MyRest.dao;

import com.example.MyRest.entity.AnimalEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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

    public AnimalEntity findById(int id) {
        return entityManager.find(AnimalEntity.class, id);
    }

    public List<AnimalEntity> findByBreed(String breed) {
        TypedQuery<AnimalEntity> query = entityManager.createQuery("FROM AnimalEntity WHERE breed = :theBreed", AnimalEntity.class);
        query.setParameter("theBreed", breed);
        return query.getResultList();
    }

    //using JPQL to create custom queries that use the Entity field names instead of SQL table names.
    public List<AnimalEntity> findAll() {
        TypedQuery<AnimalEntity> query = entityManager.createQuery("FROM AnimalEntity ORDER BY breed", AnimalEntity.class);
        return query.getResultList();
    }

    //update using 'merge' method
    @Transactional
    public void update(AnimalEntity entity) {
        entityManager.merge(entity);
    }

    //update using 'JPQL'
    @Transactional
    public void updateIntelligence(BigDecimal intelligence, int id) {
        entityManager.createQuery("UPDATE AnimalEntity SET intelligence = :intelligenceData WHERE id = :idData")
                .setParameter("intelligenceData", intelligence)
                .setParameter("idData", id)
                .executeUpdate();
    }

}
