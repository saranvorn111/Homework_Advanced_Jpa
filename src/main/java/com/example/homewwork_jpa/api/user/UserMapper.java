package com.example.homewwork_jpa.api.user;

import com.example.homewwork_jpa.api.user.web.UpdateUserDto;
import com.example.homewwork_jpa.api.user.web.CreateUserRoleDto;
import com.example.homewwork_jpa.api.user.web.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapUserToUserDto(User user);
    List<UserDto> mapUserToUserDtoList(List<User> users);
    UserDto crateNewUser(CreateUserRoleDto createUserRoleDto);

    UserDto updateUserDtoToUser (UpdateUserDto updateUserDto);



}
