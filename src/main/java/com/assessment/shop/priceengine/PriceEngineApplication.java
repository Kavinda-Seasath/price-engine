package com.assessment.shop.priceengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.assessment.shop.priceengine.data.repositories")
@SpringBootApplication
public class PriceEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceEngineApplication.class, args);
	}

}
