package com.sapiofan.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConsumer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConsumer.class);

    @KafkaListener(topics = "wiki", groupId = "someGroup")
    private void consume(String message) {
        log.info("Received message: " + message);
    }
}
