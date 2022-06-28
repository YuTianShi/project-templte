package com.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * KafkaController.
 *
 * @author shitianyu 2022-06-28 11:25
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {

    private final static String TOPIC_NAME = "test";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("send")
    public void send() {
        kafkaTemplate.send(TOPIC_NAME, 0, "key", "this is a msg");
    }

}
