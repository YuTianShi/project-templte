package com.validate.demo.controller;

import com.validate.demo.domain.Event;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController.
 *
 * @author shitianyu 2021-09-30 14:49
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public Event test(@RequestBody @Validated Event event) {
        return event;
    }

}
