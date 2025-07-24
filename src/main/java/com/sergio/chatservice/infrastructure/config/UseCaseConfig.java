package com.sergio.chatservice.infrastructure.config;

import com.sergio.chatservice.application.usecase.MessageUseCase;
import com.sergio.chatservice.domain.repository.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public MessageUseCase messageUseCase(MessageRepository messageRepository) {
        return new MessageUseCase(messageRepository);
    }
}
