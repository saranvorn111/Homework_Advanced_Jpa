package com.example.homewwork_jpa.entity.api.user;

import com.example.homewwork_jpa.entity.api.rol.Role;
import com.example.homewwork_jpa.entity.api.user.web.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserModelAssembler userModelAssembler;

    @Override
    public CollectionModel<?> findUsers() {
        List<User> users = userRepository.findAll();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public UserDto CreateNewUser(CreateUserRoleDto createUserRoleDto) {
        User user = User.builder()
                .uuid(UUID.randomUUID().toString())
                .name(createUserRoleDto.name())
                .gender(createUserRoleDto.gender())
                .email(createUserRoleDto.email())
                .password(createUserRoleDto.password())
                .phoneNumber(createUserRoleDto.phoneNumber())
                .build();
        user = userRepository.save(user);
        return userMapper.mapUserToUserDto(user);
    }


    @Override
    public EntityModel<?> findUserByUuid(String uuid) {
        User user = userRepository.findUserByUuid(uuid).orElseThrow();

        return userModelAssembler.toModel(user);
    }

    @Override
    public void createUserRole(Integer userId, List<Integer> roleId) {
        roleId.forEach(id->
        {UserRole userRole = UserRole.builder()
                .user(User.builder().id(userId).build())
                .role(Role.builder().id(id).build())
                .build();});
    }

    @Override
    public EntityModel<?> updatedUserExistedByUuid(String uuid, UpdateUserDto updateUserDto) {
        User updateUser = userRepository.findUserByUuid(uuid).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(
                        "User with uuid: %d is not found",uuid
                )));
        updateUser.setName(updateUserDto.name());
        updateUser.setGender(updateUserDto.gender());
        updateUser.setEmail(updateUserDto.email());
        updateUser.setPhoneNumber(updateUserDto.phoneNumber());

        User user = userRepository.save(updateUser);
        return userModelAssembler.toModel(user);



    }

    @Override
    public String disableUserByUuid(String uuid, IsDeleteUserDto isDeleteUserDto) {
        User user = userRepository.findUserByUuid(uuid).orElseThrow();
        user.setIsDeleted(isDeleteUserDto.isDeleted());

        User userIsDeleted = userRepository.save(user);
        return "Status is deleted"+userIsDeleted;
    }

    @Transactional
    @Override
    public void deleteUserByUuid(String uuid) {
        userRepository.deleteUserByUuid(uuid);
    }

}
