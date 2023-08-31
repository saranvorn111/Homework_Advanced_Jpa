package com.example.homewwork_jpa.entity.api.user;
import com.example.homewwork_jpa.entity.api.user.web.CreateUserRoleDto;
import com.example.homewwork_jpa.entity.api.user.web.UpdateUserDto;
import com.example.homewwork_jpa.entity.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface UserService {
    CollectionModel<?> findUsers();
    UserDto CreateNewUser(CreateUserRoleDto createUserRoleDto);

    EntityModel<?> findUserByUuid(String uuid);

    void createUserRole(Integer id, List<Integer> roleId);

    UserDto updatedUserExistedByUuid(String uuid, UpdateUserDto updateUserDto);
}
