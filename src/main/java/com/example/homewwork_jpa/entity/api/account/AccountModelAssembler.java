package com.example.homewwork_jpa.entity.api.account;

import com.example.homewwork_jpa.entity.api.account.web.AccountController;
import com.example.homewwork_jpa.entity.api.account.web.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account,EntityModel<AccountDto>> {
    @Autowired
    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @SuppressWarnings("unchecked")
    public AccountModelAssembler() {
        super(AccountController.class, (Class<EntityModel<AccountDto>>)(Class<?>) EntityModel.class);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapper.mapAccountToAccountDto(entity);
        Link selfLink = linkTo(methodOn(AccountController.class).findAllAccount()).withSelfRel();
        Link collection = linkTo(methodOn(AccountController.class)
                .findAccountByUuid(entity.getUuid())).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,selfLink,collection);
    }
}
