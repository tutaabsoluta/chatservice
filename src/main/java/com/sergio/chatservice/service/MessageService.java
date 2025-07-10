package com.sergio.chatservice.service;

import com.sergio.chatservice.model.MessageEntity;
import com.sergio.chatservice.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageEntity> findMessages() {
        return messageRepository.findAll();
    }

    public Optional<MessageEntity> findMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public MessageEntity saveMessage( MessageEntity message ) {
        return messageRepository.save( message );
    }
}
