package br.rodrigoalmeida.spring.batch.lightmin.sample.client.app2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tuxdevelop.spring.batch.lightmin.client.classic.annotation.EnableLightminClientClassic;
import org.tuxdevelop.spring.batch.lightmin.repository.annotation.EnableLightminJdbcConfigurationRepository;

@EnableLightminClientClassic
@EnableLightminJdbcConfigurationRepository
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchLightminApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchLightminApp1Application.class, args);
	}

}
