package com.example.MyRest.model;

import java.math.BigDecimal;
import java.util.Objects;

public class AnimalModel {

    private int id;
    private String breed;
    private BigDecimal intelligence;

    //no-args constructor
    public AnimalModel() {}

    public AnimalModel(int id, String breed, BigDecimal intelligence) {
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
        AnimalModel that = (AnimalModel) o;
        return id == that.id && Objects.equals(breed, that.breed) && Objects.equals(intelligence, that.intelligence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, breed, intelligence);
    }

    @Override
    public String toString() {
        return "AnimalModel{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", intelligence=" + intelligence +
                '}';
    }
}
