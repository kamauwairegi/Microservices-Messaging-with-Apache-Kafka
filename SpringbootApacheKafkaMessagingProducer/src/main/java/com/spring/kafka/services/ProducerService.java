package com.spring.kafka.services;

import com.spring.kafka.models.Message;

public interface ProducerService {
	public void send(Message message);
}
