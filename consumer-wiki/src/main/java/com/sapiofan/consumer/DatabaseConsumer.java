package com.sapiofan.consumer;

import com.sapiofan.consumer.repository.ConsumerFileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConsumer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseConsumer.class);

    @Autowired
    private ConsumerFileHandler fileHandler;

    @KafkaListener(topics = "wiki", groupId = "someGroup")
    private void consume(String message) {
        fileHandler.writeWikiToFile(message);
    }
}
