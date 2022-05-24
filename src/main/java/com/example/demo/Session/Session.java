package com.example.demo.Session;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Session {

    @Id
    private String id;

    private int numberOfTries = 0;

    public Session(int numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

}
