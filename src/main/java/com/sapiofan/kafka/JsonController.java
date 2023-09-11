package com.sapiofan.kafka;

import com.sapiofan.kafka.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class JsonController {

    private Producer producer;

    public JsonController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        producer.sendMessage(user);
        return ResponseEntity.ok("Json was sent to kafka");
    }
}
