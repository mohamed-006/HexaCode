package com.example.hexacode.Controller;

import com.example.hexacode.Entity.Messages;
import com.example.hexacode.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
public class ChatControlleur {
    @Autowired
    IMessage iMessage;


    @MessageMapping("/add")
    public Messages addMessage(@Payload Messages message) {
        return iMessage.addMessage(message);
    }
}
