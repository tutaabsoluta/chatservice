package com.sergio.chatservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
public class MessageEntity {

    public enum Role {
        USER,
        ASSISTANT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = true)
    private String prompt;

    @Column(nullable = false)
    private String response;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamp;

    @Column(nullable = true)
    private Long responseTimeMs;

    @Column(nullable = true)
    private String error;

    @Column(nullable = true)
    private Float temperature;

    @Column(nullable = true)
    private String userAgent;

    @Column(nullable = true)
    private String modelUsed;

    @Column(nullable = true)
    private Integer totalTokens;

    @Column(nullable = true)
    private Integer promptTokens;

    @Column(nullable = true)
    private Integer completionTokens;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chat_session_id", nullable = false)
    private ChatSessionEntity chatSession;

    public MessageEntity(ChatSessionEntity chatSession, Role role, String prompt, String response) {
        this.chatSession = chatSession;
        this.role = role;
        this.prompt = prompt;
        this.response = response;
    }
}
