package com.example.hexacode.WS;

import com.example.hexacode.Entity.Messages;
import com.example.hexacode.service.IMessage;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Slf4j
public class DataHandler extends TextWebSocketHandler {
    @Autowired
    IMessage iMessage;


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws IOException {
        log.info("Message:{} ", message.getPayload());

        JsonFactory factory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsontest = (String) message.getPayload();

            Messages message1 = mapper.readValue((String) message.getPayload(),Messages.class);
            //mapper.writeValue(new File("Message"),Message );

            jsontest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(message1);
            iMessage.addMessage(message1);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
