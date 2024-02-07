package com.example.MyRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

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

}
