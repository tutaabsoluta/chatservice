package com.sergio.chatservice.repository;

import com.sergio.chatservice.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
