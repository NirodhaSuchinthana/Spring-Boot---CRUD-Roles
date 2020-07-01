package com.nirodha.haulmatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HaulmaticApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaulmaticApplication.class, args);
	}

}
