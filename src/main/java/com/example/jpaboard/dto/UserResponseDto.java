package com.example.jpaboard.dto;

import lombok.Getter;

@Getter
public class UserResponseDto
{
    private final String username;

    public UserResponseDto(String username)
    {
        this.username = username;

    }
}
