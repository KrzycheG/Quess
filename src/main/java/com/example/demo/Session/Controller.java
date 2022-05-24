package com.example.demo.Session;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class Controller {


    private final SessionService sessionService;

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


}
