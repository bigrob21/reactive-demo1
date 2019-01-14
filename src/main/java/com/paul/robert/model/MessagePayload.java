package com.paul.robert.model;

import java.util.UUID;

import lombok.Data;

@Data
public class MessagePayload {
	private String id;
	private String message;
	
	public MessagePayload() {
		this.id = UUID.randomUUID().toString();
	}
	
	public MessagePayload(String message) {
		this.id = UUID.randomUUID().toString();
		this.message = message;
	}
	
	public MessagePayload(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	};
	
}
