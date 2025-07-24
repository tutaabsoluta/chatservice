package com.sergio.chatservice.domain.repository;

import com.sergio.chatservice.domain.model.ContextInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContextInfoRepository extends JpaRepository<ContextInfoEntity, Long> {
}
