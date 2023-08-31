package com.example.homewwork_jpa.entity.api.user.web;

public record UpdateUserDto(String name,
                            String gender,
                            String email,
                            String phoneNumber
                            ) {
}
