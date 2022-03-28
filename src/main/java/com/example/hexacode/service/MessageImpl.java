package com.example.hexacode.service;

import com.example.hexacode.Entity.Messages;
import com.example.hexacode.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageImpl   implements IMessage {
    @Autowired
    private MessageRepository messageInterface;


    public Messages addMessage(Messages message) {

        return messageInterface.save(message);
    }
}
