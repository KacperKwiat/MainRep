package com.kacperk.emailservice.dtos;

import lombok.Data;

@Data
public class RegisterDto {
    private String name;
    private String surname;
    private String username;
    private String password;
}
