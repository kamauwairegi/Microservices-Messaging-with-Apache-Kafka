package com.spring.kafka.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.spring.kafka.models.Message;

public interface ConsumerService {
	 public void receive(ConsumerRecord<String, Message> record);
}
