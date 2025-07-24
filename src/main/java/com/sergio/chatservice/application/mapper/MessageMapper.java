package com.sergio.chatservice.application.mapper;

import com.sergio.chatservice.domain.model.MessageEntity;
import com.sergio.chatservice.presentation.dto.CreateMessageDTO;

public class MessageMapper {

    public static MessageEntity toEntity(CreateMessageDTO dto) {
        if (dto == null) return null;
        return new MessageEntity(dto.getPrompt());
    }

    public static CreateMessageDTO toDTO(MessageEntity entity) {
        if (entity == null) return null;
        CreateMessageDTO dto = new CreateMessageDTO();
        dto.setPrompt(entity.getPrompt());
        return dto;
    }
}
