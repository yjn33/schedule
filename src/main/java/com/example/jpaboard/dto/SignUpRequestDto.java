package com.example.jpaboard.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto
{

    private final String username;
    private final String password;


    public SignUpRequestDto(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

}
