package com.spring.kafka.SpringKafkaIntegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Producer {

	private static final String TOPIC = "test";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void sendMessage(String topic, String message) {
		log.info("Entered producer To send message: " + message);
		
		kafkaTemplate.send(topic, message);
		log.info("Exiting producer, sent message successfylly ");
	}
	
	
	public void createTopic(String topic) {
		log.info("Creating new Topic by topic name: " + topic);
		TopicBuilder.name(topic).partitions(1).replicas(1).build();
		
	}
	
}

