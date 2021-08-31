package com.example.springbootjokes.controller;

import com.example.springbootjokes.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class JokeController {

    final private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String welcome(Map<String, Object> model) {
        model.put("joke", jokeService.getRandomJoke());
        return "index";
    }


}
