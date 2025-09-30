package com.pet.petcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.pet"})
@EnableJpaRepositories(basePackages = "com.pet.petrepository")
public class PetControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetControlApplication.class, args);
	}

}
