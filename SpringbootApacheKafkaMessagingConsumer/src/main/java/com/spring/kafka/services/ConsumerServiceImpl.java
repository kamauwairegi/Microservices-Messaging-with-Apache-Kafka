package com.spring.kafka.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.kafka.models.Message;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Value("${spring.kafka.topic}")
	private String kafkaTopic;

	Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	@KafkaListener(topics = "${spring.kafka.topic}")
	public void receive(ConsumerRecord<String, Message> record) {
		logger.info("Receiverd Message");
		logger.info("ID: {}",  record.value().getId());
		logger.info("Body: {}",  record.value().getBody());

	}

}
