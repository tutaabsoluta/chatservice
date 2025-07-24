package com.sergio.chatservice.application.mapper;

import com.sergio.chatservice.domain.model.ContextEntity;
import com.sergio.chatservice.presentation.dto.CreateContextDTO;

public class ContextMapper {
    public static ContextEntity toEntity(CreateContextDTO dto) {
        if(dto == null) return null;
        return new ContextEntity(dto.getCategory(), dto.getExampleQuestion(), dto.getAnswer());
    }
}
