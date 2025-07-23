package com.sergio.chatservice.repository;

import com.sergio.chatservice.model.ContextInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextInfoRepository extends JpaRepository<ContextInfoEntity, Long> {
}
