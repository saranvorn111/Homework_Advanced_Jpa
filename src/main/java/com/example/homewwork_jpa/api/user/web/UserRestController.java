package com.example.homewwork_jpa.api.user.web;

import com.example.homewwork_jpa.api.account.Account;
import com.example.homewwork_jpa.api.user.UserService;
import com.example.homewwork_jpa.api.userAccount.UserAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public CollectionModel<?> findAllUser(){
        return userService.findUsers();
    }

    @GetMapping("/{uuid}/accounts")
    public List<Account> findAllUserAccount(@PathVariable String uuid){
        return userService.findAccountByUserUuid(uuid);
    }

    @GetMapping("/{userUuid}/accounts/{accountUuid}")
    public ResponseEntity<Account> findAccountUuidWithUserUuid(@PathVariable String userUuid, @PathVariable String accountUuid){
            Account account= userService.findAccountByUuidOfUserUuid(userUuid,accountUuid);
            return ResponseEntity.ok(account);

    }


    @GetMapping("/{uuid}")
    public EntityModel<?> findUserByUuid(@PathVariable String uuid){
        return userService.findUserByUuid(uuid);
    }

    @PostMapping
    public UserDto CreateNewUser(@RequestBody CreateUserRoleDto createUserRoleDto){
        return userService.CreateNewUser(createUserRoleDto);

    }
    @PutMapping("/{uuid}")
    public EntityModel<?> updateUser(@PathVariable String uuid,@RequestBody UpdateUserDto updateUserDto){
         return userService.updatedUserExistedByUuid(uuid,updateUserDto);
    }

    @PutMapping("/{uuid}/disable")
    public String updateDisable(@PathVariable String uuid,@RequestBody IsDeleteUserDto isDeleteUserDto){
        return userService.disableUserByUuid(uuid,isDeleteUserDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid){
        userService.deleteUserByUuid(uuid);
    }

}
