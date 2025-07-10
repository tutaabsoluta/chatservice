package com.sergio.chatservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_session")
@Getter
@Setter
@NoArgsConstructor
public class ChatSessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "chatSession", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> messages = new ArrayList<>();

    public ChatSessionEntity(String content) {
        this.content = content;
    }

    // Relation methods
    public void addMessage(MessageEntity message) {
        messages.add(message);
        message.setChatSession(this);
    }

    public void removeMessage(MessageEntity message) {
        messages.remove(message);
        message.setChatSession(null);
    }
}
