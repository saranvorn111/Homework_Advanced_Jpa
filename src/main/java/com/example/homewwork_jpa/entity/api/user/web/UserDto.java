package com.example.homewwork_jpa.entity.api.user.web;

import java.util.List;

public record UserDto(String uuid,
                      String name,
                      String gender,
                      String email,
                      String phoneNumber,
                      Boolean isStudent,
                      String studentCardNo,
                      List<UserRoleDto> userRoles) {
}
