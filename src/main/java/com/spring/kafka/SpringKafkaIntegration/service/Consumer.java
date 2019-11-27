package com.spring.kafka.SpringKafkaIntegration.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {

	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message) {
		log.info("Entered Consumer,successfully consumed message: " + message);
	}

	@KafkaListener(topics = "userstest", groupId = "group_id")
	public void consumeUsersTest(String message) {
		log.info("Entered Consumer,successfully consumed message: " + message);
	}

}
