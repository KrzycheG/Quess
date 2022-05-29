package com.example.demo.Session;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class Controller {


    private final SessionService sessionService;

    @GetMapping
    public int dupa(){

        return 1;

    }

    @PostMapping(path = "/start")
    public String start() {

            return sessionService.start();

    }

    @PostMapping(path = "/quess")
    public HashMap<String,String> quess(
            @RequestBody Map<String, String> data

    ){

        return sessionService.quess(data.get("sess"),Integer.valueOf(data.get("number")));

    }

    @GetMapping(path = "/highscores")
    public List<Session> highscores(){

        return sessionService.highscores();

    }

}
