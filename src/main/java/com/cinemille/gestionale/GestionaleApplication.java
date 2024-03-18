package com.cinemille.gestionale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cinemille.gestionale.controller,com.cinemille.gestionale.service")
public class GestionaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionaleApplication.class, args);
	}

}
