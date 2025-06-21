package com.merzmostafaei.store.controllers;

import com.merzmostafaei.store.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/rest")
    public Message sayHello(){

        return new Message("Hello Rest");
    }
}
