package com.example.demo;
import com.example.demo.Session.Session;
import com.example.demo.Session.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner ( SessionRepository sessRepo){

		return args -> {

			Session frst = new Session();


			sessRepo.insert(frst);

		};


	}
}
