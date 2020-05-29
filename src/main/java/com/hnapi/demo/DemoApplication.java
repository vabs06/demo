package com.hnapi.demo;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableJpaRepositories("com.hnapi.demo.repository")
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@CacheEvict(value = "topStories", allEntries = true)


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		LOGGER.debug("Application Ready to serve");

	}

}
