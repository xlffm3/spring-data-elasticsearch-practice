package com.example.elasticsearch.user.application;

public class UserRequestDto {

    private String name;
    private String description;

    private UserRequestDto() {
    }

    public UserRequestDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
