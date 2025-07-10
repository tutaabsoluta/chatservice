package com.sergio.chatservice.controller;

import com.sergio.chatservice.dto.CreateMessageDTO;
import com.sergio.chatservice.model.MessageEntity;
import com.sergio.chatservice.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/message")
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<?> findMessages() {
        List<MessageEntity> messages = messageService.findMessages();
        if (messages.isEmpty()) {
            return ResponseEntity.ok().body(
                    Map.of("message", "There is no messages")
            );
        }

        return ResponseEntity.ok().body(messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {
        return messageService.findMessageById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() ->
                        ResponseEntity.status(404).body(
                                Map.of("message", "The message with " + id + " was not found")
                        )
                );
    }

    @PostMapping
    public ResponseEntity<MessageEntity> saveMessage(@RequestBody @Valid CreateMessageDTO dto) {
        MessageEntity message = new MessageEntity();
        message.setPrompt(dto.getPrompt());
        return ResponseEntity.ok( messageService.saveMessage( message ) );
    }
}
