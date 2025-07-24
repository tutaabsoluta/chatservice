package com.sergio.chatservice.application.usecase;

import com.sergio.chatservice.domain.model.ContextEntity;
import com.sergio.chatservice.domain.repository.ContextRepository;

import java.util.List;
import java.util.Optional;

public class ContextUseCase {

    private final ContextRepository contextInfoRepository;

    public ContextUseCase(ContextRepository contextInfoRepository) {
        this.contextInfoRepository = contextInfoRepository;
    }
    public List<ContextEntity> findContext() {
        return contextInfoRepository.findAll();
    }

    public Optional<ContextEntity> findContextById(Long id) {
        return contextInfoRepository.findById(id);
    }

    public ContextEntity saveContext(ContextEntity contextInfo) {
        return contextInfoRepository.save(contextInfo);
    }

    public void deleteContext(Long id) { contextInfoRepository.deleteById(id); }

    public ContextEntity updateContext(ContextEntity contextInfo) { return contextInfoRepository.save(contextInfo); }
}





