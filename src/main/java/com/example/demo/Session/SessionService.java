package com.example.demo.Session;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class SessionService {


    private final SessionRepository sessionRepository;

    public String start() {

        Session str = new Session();
        sessionRepository.insert(str);

        return sessionRepository.findAll().get(sessionRepository.findAll().size() -1 ).getId();
    }

    public HashMap<String, String> quess(String sess, Integer number) {

        HashMap<String,String> result = new HashMap<>();

        if(sessionRepository.findById(sess).isPresent()){

            int randomNumber = (int) ((Math.random() * (100 - 1)) + 1);

            int numberOfTries = sessionRepository.findById(sess).get().getNumberOfTries();


            Session s =  sessionRepository.findById(sess).get();
            sessionRepository.
            s.setNumberOfTries(numberOfTries++);


            result.put("Session Id: ", sess);
            result.put("Number of tries: ", Integer.toString(numberOfTries));

            if(randomNumber == number){

                result.put("Result: " , "Winner");


            }else if( number > randomNumber){

                result.put("Result: ", "Too big :O");

            }else{
                result.put("Result: ", "Too small :(");
            }

        }else {

            result.put("Session with given Id doesnt exist", "Try again");
        }


        return result;
    }
}