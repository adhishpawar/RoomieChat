package com.adhish.chat.chat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebScoketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        // /topic/messages -->example having prefix topic which Subscribe by Client
        config.setApplicationDestinationPrefixes("/App");
        // /app/chat
        // server-side:

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
            registry.addEndpoint("/chat")  //Connection Establishment
                    .setAllowedOrigins("http://localhost:3000") //To fetch from Client
                    .withSockJS(); //Determine Fallback

    }// "Chat" Endpoint on which connection will be establish



}
