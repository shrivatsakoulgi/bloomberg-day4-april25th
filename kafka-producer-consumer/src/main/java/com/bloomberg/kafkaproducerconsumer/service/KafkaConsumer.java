package com.bloomberg.kafkaproducerconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="greetings",groupId="mygroup")
	public void consumeFromTopic(String message) {
		System.out.println("Consumed Message: "+message);
	}

}
