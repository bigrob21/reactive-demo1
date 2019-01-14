package com.paul.robert.repos;

import java.util.List;

import com.paul.robert.model.MessagePayload;

public interface MessageRepositoryAccessor {
	public void addValue(String message);
	public void addValues(String... messages);
	public List<MessagePayload> getInternalData();
}
