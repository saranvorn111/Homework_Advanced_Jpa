package com.example.homewwork_jpa.entity.api.account;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.example.homewwork_jpa.entity.api.account.web.AccountDto;
import com.example.homewwork_jpa.entity.api.account.web.AccountRepository;
import com.example.homewwork_jpa.entity.api.account.web.CreateAccountDto;
import com.example.homewwork_jpa.entity.api.account.web.UpdateAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    private final AccountModelAssembler accountModelAssembler;
    private final AccountMapper accountMapper;


    @Override
    public CollectionModel<?> finAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);
    }

    @Override
    public Account createAccount(CreateAccountDto createAccountDto) {

        Account account = accountMapper.createAccount(createAccountDto);

        return accountRepository.save(account);
    }

    @Override
    public EntityModel<?> findAccountByUuid(String uuid) {
        Account account = accountRepository.findAccountByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);
    }

    @Override
    public Account updateAccountByUuid(String uuid, UpdateAccountDto updateAccountDto) {
        Account account = accountMapper.updateAccountDtoToAccount(updateAccountDto);
        //for update Bean
        BeanUtils.copyProperties(uuid,updateAccountDto);

        return accountRepository.save(account);
    }



}
