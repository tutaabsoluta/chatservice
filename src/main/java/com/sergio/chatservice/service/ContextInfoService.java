package com.sergio.chatservice.service;

import com.sergio.chatservice.model.ContextInfoEntity;
import com.sergio.chatservice.repository.ContextInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContextInfoService {
    private final ContextInfoRepository contextInfoRepository;
    public ContextInfoService(ContextInfoRepository contextInfoRepository) {
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
