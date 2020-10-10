package br.rodrigoalmeida.spring.batch.lightmin.sample.server;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tuxdevelop.spring.batch.lightmin.server.annotation.EnableLightminServer;

@EnableBatchProcessing
@EnableLightminServer
@SpringBootApplication
public class SpringBatchLightminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchLightminServerApplication.class, args);
	}

}
