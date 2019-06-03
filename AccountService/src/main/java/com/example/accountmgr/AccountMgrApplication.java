package com.example.accountmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration;

@SpringBootApplication
public class AccountMgrApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountMgrApplication.class, args);
	}
	
	@Bean
	public io.opentracing.Tracer getTracer()  {
		Configuration config = Configuration.fromEnv();
	    return config.getTracer();  
	}
}
