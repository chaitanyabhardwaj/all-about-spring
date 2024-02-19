package com.example.MyRest.controller;

import com.example.MyRest.service.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyRestController {

    //inject values
    @Value("${park.name}")
    private String parkName;

    @Value("${park.country}")
    private String country;

    @Value("${park.establishmentYear}")
    private String establishmentYear;

    private Animal animal;

    public MyRestController(Animal animal) {
        this.animal = animal;
    }

    @GetMapping("/test")
    public String test() {
        return "It's working!";
    }

    @GetMapping("/animalFarm")
    public String animalFarm(
            @RequestParam(name = "animal1") String animal1,
            @RequestParam(name = "animal2") String animal2) {
        String a1 = animal1;
        String a2 = animal1;
        if(animal1.length() < animal2.length()) a1 = animal2;
        else a2 = animal2;
        return "A %s jumps over a %s".formatted(a1,a2);
    }

    @GetMapping("/suggestAnimal")
    public String suggestAnimal() {
        List<String> animalList = List.of("Dog", "Cat", "Bird", "Tiger", "Elephant", "Camel", "Donkey", "Lizard");
        int i = ((int)Math.floor(Math.random() * 10)) % 8;
        return animalList.get(i);
    }

    @GetMapping("/parkDetails")
    public Map<String, String> parkDetails() {
        Map<String,String> parkDetailsMap = new HashMap<>();
        parkDetailsMap.put("Park Name", parkName);
        parkDetailsMap.put("Country", country);
        parkDetailsMap.put("Establishment Year", establishmentYear);
        return parkDetailsMap;
    }

    @GetMapping("/favAnimal")
    public String getFavAnimal() {
        return animal.getName();
    }

}
