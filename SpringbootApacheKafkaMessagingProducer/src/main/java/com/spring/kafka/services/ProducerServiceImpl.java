package com.spring.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.spring.kafka.models.Message;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	@Value("${spring.kafka.topic}")
	private String kafkaTopic;

	public void send(Message message) {
		kafkaTemplate.send(kafkaTopic, message);

	}

}
