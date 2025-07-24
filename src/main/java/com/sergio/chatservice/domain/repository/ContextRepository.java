package com.sergio.chatservice.domain.repository;

import com.sergio.chatservice.domain.model.ContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextRepository extends JpaRepository<ContextEntity, Long> {
}
