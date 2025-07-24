package com.sergio.chatservice.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateContextDTO {

    @Size(min = 3, max = 50)
    private String category;

    @Size(min = 5, max = 200)
    private String exampleQuestion;

    @Size(min = 5, max = 1000)
    private String answer;
}
