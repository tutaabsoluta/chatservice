package com.sergio.chatservice.repository;

import com.sergio.chatservice.model.ChatSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSessionEntity, Long> {}

