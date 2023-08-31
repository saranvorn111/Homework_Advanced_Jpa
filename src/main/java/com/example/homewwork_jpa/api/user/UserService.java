package com.example.homewwork_jpa.api.user;
import com.example.homewwork_jpa.api.account.Account;
import com.example.homewwork_jpa.api.user.web.IsDeleteUserDto;
import com.example.homewwork_jpa.api.user.web.UpdateUserDto;
import com.example.homewwork_jpa.api.user.web.CreateUserRoleDto;
import com.example.homewwork_jpa.api.user.web.UserDto;
import com.example.homewwork_jpa.api.userAccount.UserAccount;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    CollectionModel<?> findUsers();
    UserDto CreateNewUser(CreateUserRoleDto createUserRoleDto);

    EntityModel<?> findUserByUuid(String uuid);

    void createUserRole(Integer id, List<Integer> roleId);

    EntityModel<?> updatedUserExistedByUuid(String uuid, UpdateUserDto updateUserDto);

    String disableUserByUuid(String uuid, IsDeleteUserDto isDeleteUserDto);

    void deleteUserByUuid(String uuid);
    List<Account> findAccountByUserUuid(String uuid);

    Account findAccountByUuidOfUserUuid(String userUuid, String accountUuid);


}
