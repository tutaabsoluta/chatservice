package com.sergio.chatservice.presentation.controller;

import com.sergio.chatservice.application.mapper.ContextMapper;
import com.sergio.chatservice.application.usecase.ContextUseCase;
import com.sergio.chatservice.domain.model.ContextEntity;
import com.sergio.chatservice.presentation.dto.CreateContextDTO;
import com.sergio.chatservice.presentation.dto.UpdateContextDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/context")
public class ContextController {

    private final ContextUseCase contextUseCase;

    public ContextController(ContextUseCase contextUseCase) {
        this.contextUseCase = contextUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getContext() {
        List<ContextEntity> context = contextUseCase.findContext();

        if (context.isEmpty()) {
            return ResponseEntity.ok().body(
                    Map.of("message", "There is no context info")
            );
        }
        return ResponseEntity.ok(context);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContextById(@PathVariable Long id) {
        var contextOptional = contextUseCase.findContextById(id);
        if (contextOptional.isEmpty()) {
            return ResponseEntity.status(404).body(
                    Map.of("message", "The context with id " + id + " was not found")
            );
        }
        return ResponseEntity.ok(contextOptional.get());
    }

    @PostMapping
    public ResponseEntity<ContextEntity> saveContext(@RequestBody @Valid CreateContextDTO dto) {
        ContextEntity context = ContextMapper.toEntity(dto);
        return ResponseEntity.ok(contextUseCase.saveContext(context));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContext(@PathVariable Long id, @RequestBody @Valid UpdateContextDTO dto) {
        var optionalContext = contextUseCase.findContextById(id);
        if (optionalContext.isEmpty()) {
            return ResponseEntity.status(404).body(
                    Map.of("message", "The context with id " + id + " was not found")
            );
        }

        ContextEntity existingContext = optionalContext.get();

        existingContext.setExampleQuestion(dto.getExampleQuestion());
        existingContext.setCategory(dto.getCategory());
        existingContext.setAnswer(dto.getAnswer());

        ContextEntity updatedContext = contextUseCase.updateContext(existingContext);

        return ResponseEntity.ok(updatedContext);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContext(@PathVariable Long id) {
        var contextExists = contextUseCase.findContextById(id).isPresent();

        if (!contextExists) {
            return ResponseEntity.status(404).body(
                    Map.of("message", "The context with id " + id + " was not found")
            );
        }

        contextUseCase.deleteContext(id);
        return ResponseEntity.noContent().build();
    }
}
