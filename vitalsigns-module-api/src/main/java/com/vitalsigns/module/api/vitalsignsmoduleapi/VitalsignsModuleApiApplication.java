package com.vitalsigns.module.api.vitalsignsmoduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class VitalsignsModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitalsignsModuleApiApplication.class, args);
	}

}
