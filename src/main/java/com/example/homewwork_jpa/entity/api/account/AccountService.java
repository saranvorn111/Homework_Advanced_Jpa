package com.example.homewwork_jpa.entity.api.account;

import com.example.homewwork_jpa.entity.api.account.web.AccountDto;
import com.example.homewwork_jpa.entity.api.account.web.CreateAccountDto;
import com.example.homewwork_jpa.entity.api.account.web.UpdateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.Collection;

public interface AccountService {
    CollectionModel<?> finAllAccount();

    Account createAccount(CreateAccountDto createAccountDto);

    EntityModel<?> findAccountByUuid(String uuid);

    EntityModel<?> renameAccountByUuid(String uuid, UpdateAccountDto updateAccountDto);








}
