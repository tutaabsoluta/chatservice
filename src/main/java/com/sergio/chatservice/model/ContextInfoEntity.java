package com.sergio.chatservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "context_info")
@Getter
@Setter
@NoArgsConstructor
public class ContextInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String exampleQuestion;

    @Column(nullable = false)
    private String answer;

    public ContextInfoEntity(String category, String exampleQuestion, String answer) {
        this.category = category;
        this.exampleQuestion = exampleQuestion;
        this.answer = answer;
    }
}
