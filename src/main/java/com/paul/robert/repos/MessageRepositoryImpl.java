package com.paul.robert.repos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.paul.robert.model.MessagePayload;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class MessageRepositoryImpl implements MessageRepositoryAccessor, MessageRepository {

	private final List<MessagePayload> internalData = new ArrayList<>();
	private static final Predicate<String> isNotNullOrEmptyString = (s) -> s != null && !s.trim().isEmpty();
			
	public Flux<MessagePayload> getAll() {
		return Flux.fromStream(getInternalData().stream());
	}
	
	public Mono<MessagePayload> getById(String id){
		return Mono.just(getInternalData()
							.stream()
							.filter(m -> m.getId().equals(id))
							.findFirst()
							//TODO: hmmm... may want to check out if returning null is good, 
							//kinda iffy but need to check this out later!
							.orElse(null));
	}
	
	//================= INTERNAL METHODS NOT FOR PUBLIC API CONSUMPTION ============
	
	@Override
	public void addValue(String message) {
		Optional.ofNullable(message).filter(isNotNullOrEmptyString)
			.map(MessagePayload::new)
			.ifPresent(internalData::add);
	}

	@Override
	public void addValues(String... messages) {
		Arrays.asList(messages)
			.stream()
			.filter(isNotNullOrEmptyString)
			.map(MessagePayload::new)
			.forEach(internalData::add);
	}

	@Override
	public List<MessagePayload> getInternalData() {
		return Collections.unmodifiableList(internalData);
	}

}
