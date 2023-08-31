package com.example.homewwork_jpa.entity.api.user;

import com.example.homewwork_jpa.entity.api.rol.Role;
import com.example.homewwork_jpa.entity.api.user.web.CreateUserRoleDto;
import com.example.homewwork_jpa.entity.api.user.web.UpdateUserDto;
import com.example.homewwork_jpa.entity.api.user.web.UserDto;
import com.example.homewwork_jpa.entity.api.user.web.UserRepository;
import lombok.RequiredArgsConstructor;
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
    public UserDto updatedUserExistedByUuid(String uuid, UpdateUserDto updateUserDto) {
        User updateUser = userRepository.findUserByUuid(uuid).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(
                        "User with uuid: %d is not found",uuid
                )));


        return null;

    }


}
