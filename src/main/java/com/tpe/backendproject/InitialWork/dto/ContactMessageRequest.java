package com.tpe.backendproject.InitialWork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactMessageRequest {

    @NotNull(message = "Please enter your name")
    @Size(min = 3, max = 16, message = "Your name should be at least 4 chars")
    private String name;

    @NotNull(message = "Please enter your email")
    @Email(message = "Please enter valid email")
    private String email;

    @NotNull(message = "Please enter the subject")
    private String subject;

    @NotNull(message = "Please enter your message")
    private String message;

}
