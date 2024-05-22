package com.br.sitevenhajunto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SiteVenhaJuntoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteVenhaJuntoApplication.class, args);
		log.info("http://localhost:8080/cadastro");
		log.info("http://localhost:8080/h2-console");

	}

}
