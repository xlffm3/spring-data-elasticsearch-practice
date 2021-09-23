package com.example.elasticsearch.user.presentation;

import com.example.elasticsearch.user.application.UserResponseDto;

public class UserResponse {

    private Long id;
    private String name;
    private String description;

    private UserResponse() {
    }

    public UserResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static UserResponse from(UserResponseDto userResponseDto) {
        return new UserResponse(
            userResponseDto.getId(),
            userResponseDto.getName(),
            userResponseDto.getDescription()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
