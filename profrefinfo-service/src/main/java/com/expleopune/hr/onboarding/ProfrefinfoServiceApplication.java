package com.expleopune.hr.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProfrefinfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfrefinfoServiceApplication.class, args);
	}

}
