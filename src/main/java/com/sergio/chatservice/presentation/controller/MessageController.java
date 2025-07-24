package com.sergio.chatservice.presentation.controller;

import com.sergio.chatservice.application.mapper.MessageMapper;
import com.sergio.chatservice.application.usecase.MessageUseCase;
import com.sergio.chatservice.presentation.dto.CreateMessageDTO;
import com.sergio.chatservice.domain.model.MessageEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageUseCase messageUseCase;
    public MessageController(MessageUseCase messageUseCase) {
        this.messageUseCase = messageUseCase;
    }

    @GetMapping
    public ResponseEntity<?> findMessages() {
        List<MessageEntity> messages = messageUseCase.findMessages();
        if (messages.isEmpty()) {
            return ResponseEntity.ok().body(
                    Map.of("message", "There are no messages")
            );
        }

        return ResponseEntity.ok().body(messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        return messageUseCase.findMessageById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(404).body(
                                Map.of("message", "The message with " + id + " was not found")
                        )
                );
    }

    @PostMapping
    public ResponseEntity<MessageEntity> saveMessage(@RequestBody @Valid CreateMessageDTO dto) {
        MessageEntity message = MessageMapper.toEntity(dto);
        message.setPrompt(dto.getPrompt());
        return ResponseEntity.ok( messageUseCase.saveMessage( message ) );
    }
}
