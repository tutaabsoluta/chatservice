package com.sergio.chatservice.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateMessageDTO {

    @NotBlank(message = "The prompt can't be empty")
    @Size(max = 1000, message = "Prompt is too long (max 1000 characters)")
    private String prompt;

}
