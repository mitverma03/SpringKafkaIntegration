package com.spring.kafka.SpringKafkaIntegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.SpringKafkaIntegration.service.Producer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class KafkaController {

	@Autowired
	private Producer producer;
	
	@GetMapping(path = "/publish")
	public void sendMessage(@RequestParam("message") String message, @RequestParam("topic") String topic) throws InterruptedException {
		log.info("Entered controller with Topic & message: " + topic + ", " + message);
		for(int i=0; i<=50; i++) {
			producer.sendMessage(topic, message + i);
			Thread.sleep(1000);
		}
		log.info("Exiting controller");
	}
	
	@GetMapping(path = "/createtopic")
	public void createTopic(@RequestParam("topic") String topic) throws InterruptedException {
		log.info("Entered controller with Topic: " + topic);
		producer.createTopic(topic);
		log.info("Exiting controller");
	}
}
