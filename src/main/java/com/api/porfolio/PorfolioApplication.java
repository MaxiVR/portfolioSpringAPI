package com.api.porfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class PorfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorfolioApplication.class, args);
	}

}
