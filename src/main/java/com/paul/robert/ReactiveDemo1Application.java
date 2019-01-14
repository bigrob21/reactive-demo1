package com.paul.robert;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.paul.robert.endpoints.MessagePayloadHandler;;

@SpringBootApplication
public class ReactiveDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemo1Application.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> messageRoutes(@Autowired MessagePayloadHandler handler){
		return RouterFunctions
			.route(GET("/")
			.and(accept(MediaType.APPLICATION_JSON)), 
					handler::sayHello);	
	}
	
}
