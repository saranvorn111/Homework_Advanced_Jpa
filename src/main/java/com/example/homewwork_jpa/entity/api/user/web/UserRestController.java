package com.example.homewwork_jpa.entity.api.user.web;

import com.example.homewwork_jpa.entity.api.user.User;
import com.example.homewwork_jpa.entity.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public CollectionModel<?> findAllUser(){
        return userService.findUsers();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findUserByUuid(@PathVariable String uuid){
        return userService.findUserByUuid(uuid);
    }

    @PostMapping
    public UserDto CreateNewUser(@RequestBody CreateUserRoleDto createUserRoleDto){
        return userService.CreateNewUser(createUserRoleDto);

    }


}
