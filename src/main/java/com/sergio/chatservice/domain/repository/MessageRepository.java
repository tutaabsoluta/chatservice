package com.sergio.chatservice.domain.repository;

import com.sergio.chatservice.domain.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
