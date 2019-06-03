package com.example.ordermgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration;

@SpringBootApplication
public class OrderMgrApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderMgrApplication.class, args);
	}
	
	@Bean
	public io.opentracing.Tracer getTracer()  {
		Configuration config = Configuration.fromEnv();
	    return config.getTracer();  
	}
}
