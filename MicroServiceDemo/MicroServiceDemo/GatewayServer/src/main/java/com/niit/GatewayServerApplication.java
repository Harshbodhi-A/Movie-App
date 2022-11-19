package com.niit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableEurekaClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder){
		return builder.routes()
				.route(x->x.path("/api/v1/**").uri("lb://USER-AUTHENTICATION-SERVICE"))
				.route(x->x.path("/api/v2/**").uri("lb://USER-MOVIE-SERVICE"))
				.build();
	}

}
