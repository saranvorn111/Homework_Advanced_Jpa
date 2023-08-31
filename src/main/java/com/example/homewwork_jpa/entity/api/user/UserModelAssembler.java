package com.example.homewwork_jpa.entity.api.user;

import com.example.homewwork_jpa.entity.api.account.Account;
import com.example.homewwork_jpa.entity.api.account.web.AccountDto;
import com.example.homewwork_jpa.entity.api.user.web.UserDto;
import com.example.homewwork_jpa.entity.api.user.web.UserRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.stereotype.Component;
@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User,EntityModel<UserDto>> {

    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @SuppressWarnings("unchecked")
    public UserModelAssembler() {
        super(UserRestController.class, (Class<EntityModel<UserDto>>) (Class) EntityModel.class);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapper.mapUserToUserDto(entity);

        Link selfLink = linkTo(methodOn(UserRestController.class).findAllUser()).withSelfRel();

        Link collection = linkTo(methodOn(UserRestController.class).findUserByUuid(entity.getUuid())).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(userDto,selfLink,collection);
    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }
}
