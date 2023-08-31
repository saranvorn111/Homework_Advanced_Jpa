package com.example.homewwork_jpa.api.account;

import com.example.homewwork_jpa.api.account.web.ChangeTransferLimitAccountDto;
import com.example.homewwork_jpa.api.account.web.CreateAccountDto;
import com.example.homewwork_jpa.api.account.web.IsDeletedAccountDto;
import com.example.homewwork_jpa.api.account.web.RenameAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    CollectionModel<?> finAllAccount();

    Account createAccount(CreateAccountDto createAccountDto);

    EntityModel<?> findAccountByUuid(String uuid);

    EntityModel<?> renameAccountByUuid(String uuid, RenameAccountDto renameAccountDto);

    EntityModel<?> changeTransferLimitByUuid(String uuid, ChangeTransferLimitAccountDto changeTransferLimitAccountDto);

    String isDeleteAccountByUuid(String uuid, IsDeletedAccountDto isDeletedAccountDto);








}
