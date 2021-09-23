package com.example.elasticsearch.user.application;

import com.example.elasticsearch.user.domain.User;
import com.example.elasticsearch.user.presentation.UserResponse;

public class UserResponseDto {

    private Long id;
    private String name;
    private String description;

    private UserResponseDto() {
    }

    public UserResponseDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getDescription());
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
