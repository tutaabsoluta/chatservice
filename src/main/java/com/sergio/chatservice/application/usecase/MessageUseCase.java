package com.sergio.chatservice.application.usecase;
import com.sergio.chatservice.domain.model.MessageEntity;
import com.sergio.chatservice.domain.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

public class MessageUseCase {
    private final MessageRepository messageRepository;

    public MessageUseCase(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageEntity> findMessages() {
        return messageRepository.findAll();
    };

    public Optional<MessageEntity> findMessageById(Long id) {
        return messageRepository.findById(id);
    };

    public MessageEntity saveMessage( MessageEntity message ) {
        return messageRepository.save( message );
    }

}

