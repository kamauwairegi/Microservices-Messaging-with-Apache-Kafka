package com.spring.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.models.Message;
import com.spring.kafka.services.ProducerService;

@RestController
public class MessageController {
	
	@Autowired
	ProducerService producer;

	@GetMapping(value = "/send")
	public String producer(@RequestParam("message") String content) {
		long id = (long)(Math.random() * 50 + 1);
		Message message = new Message();
		message.setId(id);
		message.setBody(content);
		
		producer.send(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
}
