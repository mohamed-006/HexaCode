package com.example.hexacode.Config;

import com.example.hexacode.WS.DataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    /**
     *http://localhost:8083/data
     * @param webSocketHandlerRegistryregistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistryregistry) {
        webSocketHandlerRegistryregistry.addHandler(new DataHandler(), "/data");
    }

    @Bean
    DataHandler getDataHandler(){
        return new DataHandler();
    }
}
