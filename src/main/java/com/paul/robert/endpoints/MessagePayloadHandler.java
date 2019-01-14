package com.paul.robert.endpoints;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.paul.robert.model.MessagePayload;

import reactor.core.publisher.Mono;

@Component
public class MessagePayloadHandler {

	public Mono<ServerResponse> sayHello(ServerRequest request){
		var payload = 
				new MessagePayload("Hello There Reactively via Spring Web Flux Reactive Paradigm!!!");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(BodyInserters.fromObject(payload));
	}
	
}
