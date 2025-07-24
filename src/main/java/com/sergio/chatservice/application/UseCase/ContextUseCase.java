package com.sergio.chatservice.application.usecase;

import com.sergio.chatservice.domain.model.ContextInfoEntity;
import com.sergio.chatservice.domain.repository.ContextInfoRepository;

import java.util.List;
import java.util.Optional;

public class ContextUseCase {

    private final ContextInfoRepository contextInfoRepository;

    public ContextUseCase(ContextInfoRepository contextInfoRepository) {
        this.contextInfoRepository = contextInfoRepository;
    }
    public List<ContextInfoEntity> findContextInfo() {
        return contextInfoRepository.findAll();
    }

    public Optional<ContextInfoEntity> findContextInfoById(Long id) {
        return contextInfoRepository.findById(id);
    }

    public ContextInfoEntity saveContextInfo(ContextInfoEntity contextInfo) {
        return contextInfoRepository.save(contextInfo);
    }
}





