package com.example.demo.Session;

import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Session {

    @Id
    private String id;

    private int numberOfTries = 1;

    public Session(String id) {
        this.id = id;
    }

    public Session(String id, int numberOfTries) {
        this.id = id;
        this.numberOfTries = numberOfTries;
    }
}
