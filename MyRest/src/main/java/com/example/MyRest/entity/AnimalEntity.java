package com.example.MyRest.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="animal")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="breed")
    private String breed;

    @Column(name="intelligence")
    private BigDecimal intelligence;

    //no-args constructor
    public AnimalEntity() {}

    public AnimalEntity(int id, String breed, BigDecimal intelligence) {
        this.id = id;
        this.breed = breed;
        this.intelligence = intelligence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public BigDecimal getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(BigDecimal intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalEntity animalEntity = (AnimalEntity) o;
        return id == animalEntity.id && Objects.equals(breed, animalEntity.breed) && Objects.equals(intelligence, animalEntity.intelligence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, breed, intelligence);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", intelligence=" + intelligence +
                '}';
    }
}
