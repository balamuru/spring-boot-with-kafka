package com.demo.controllers;

import com.demo.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @GetMapping(value = "/dummy")
    public String sendMessageToKafkaTopicAndReturnDone() {
        final LocalDateTime date = LocalDateTime.now();
        this.producer.sendMessage("sample message "+ date);
        return date.toString();
    }

}
