package com.example.homewwork_jpa.api.user.web;

public record UpdateUserDto(String name,
                            String gender,
                            String email,
                            String phoneNumber
                            ) {
}
