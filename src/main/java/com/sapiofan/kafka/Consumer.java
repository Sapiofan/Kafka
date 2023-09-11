package com.sapiofan.kafka;

import com.sapiofan.kafka.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "someGroup")
    public void consume(User user) {
        log.info("Received message: " + user);
    }
}
