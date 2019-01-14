package com.paul.robert.repos;

import com.paul.robert.model.MessagePayload;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageRepository {
	public Flux<MessagePayload> getAll();
	public Mono<MessagePayload> getById(String id);
	
}
