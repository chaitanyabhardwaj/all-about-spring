package com.example.MyRest.controller;

import com.example.MyRest.model.AnimalModel;
import com.example.MyRest.service.Animal;
import com.example.MyRest.service.Plant;
import com.example.util.AnimalNotFoundException;
import com.example.util.MyRestUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    private Animal animal2;

    private Animal animal3;

    private Plant plant;

    @Autowired
    private MyRestUtil util;

    public MyRestController(Animal animal) {
        System.out.println("In constructor of " + getClass().getSimpleName());
        this.animal = animal;
    }

    @Autowired
    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    @Autowired
    public void setAnimal2(@Qualifier("dogService") Animal animal2) {
        this.animal2 = animal2;
    }

    @Autowired
    public void setAnimal3(@Qualifier("birdService") Animal animal3) {
        this.animal3 = animal3;
    }

    @GetMapping("/test")
    public String test() {
        return "It's working!";
    }

    @GetMapping("/animalFarm")
    public String animalFarm(
            @RequestParam(name = "animal1") String animal1,
            @RequestParam(name = "animal2") String animal2) {
        return util.animalFarmHelper(animal1, animal2);
    }

    @GetMapping("/get/{animalName}")
    public AnimalModel getAnimalByName(@PathVariable String animalName) {
        if(animal.findByBreed(animalName) == null)
            throw new AnimalNotFoundException(animalName + " is not present in " + parkName);
        return animal.findByBreed(animalName);
    }

    @GetMapping("/getAllAnimals")
    public List<AnimalModel> getAll() {
        return animal.findAll();
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
        return animal.getBreed();
    }

    @GetMapping("/favAnimal2")
    public String getFavAnimal2() {
        return animal2.getBreed();
    }

    @GetMapping("/favAnimal3")
    public String getFavAnimal3() {
        return animal3.getBreed();
    }

    @GetMapping("/favTree")
    public String getFavTree() { return plant.getSpecies(); }

    @GetMapping("/checkAnimalScope")
    public String checkAnimalScope() {
        return "Comparing animal and animal2: " + (animal == animal2);
    }

    @GetMapping("/increaseScopeFlag")
    public String increaseScopeFlag() {
        animal2.increaseI();
        return "Animal: " + animal.getI() + ", Animal2: " + animal2.getI();
    }

    @PostMapping("/putAnimalInPark")
    public String putAnimalInPark(@RequestBody AnimalModel animalModel) {
        if(animalModel.getId() == null || animalModel.getId() == 0)
            animalModel.setId(-1);
        animal.save(animalModel);
        return "Saved!";
    }

    @GetMapping("/getAnimalFromPark")
    public String getAnimalFromPark(
            @RequestParam(name="id", required = false) Integer id,
            @RequestParam(name="breed", required = false) String breed) {
        if(id == null && breed == null) {
            return animal.findAll().toString();
        }
        AnimalModel animalModel;
        if(id != null)
            animalModel = animal.findById(id);
        else
            animalModel = animal.findByBreed(breed);
        return (animalModel != null) ? animalModel.toString() : "Not found";
    }

    @PostMapping("/updateAnimalFromPark")
    public String updateAnimalFromPark(@RequestBody AnimalModel model) {
        if(model.getBreed() == null || model.getBreed().isBlank() || model.getBreed().isEmpty()) {
            animal.updateIntelligence(model.getIntelligence(), model.getId());
            return "Updated intelligence!";
        }
        animal.update(model);
        return "Updated!";
    }

    @DeleteMapping("/deleteAnimalFromPark")
    public String deleteAnimalFromPark(@RequestBody AnimalModel model) {
        if(model.getId() == null) {
            animal.delete(model);
            return "Deleted!";
        }
        animal.delete(model.getId());
        return "Deleted By Id!";
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + getClass().getSimpleName() + " has been constructed!");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Bean " + getClass().getSimpleName() + " is being destroyed!");
    }

}
