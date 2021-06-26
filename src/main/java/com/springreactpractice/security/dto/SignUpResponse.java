package com.springreactpractice.security.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
public class SignUpResponse {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

}
