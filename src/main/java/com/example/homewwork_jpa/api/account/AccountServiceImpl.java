package com.example.homewwork_jpa.api.account;

import com.example.homewwork_jpa.api.account.web.*;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

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
    public EntityModel<?> renameAccountByUuid(String uuid, RenameAccountDto renameAccountDto) {
        Account account = accountRepository.findAccountByUuid(uuid).orElseThrow();

        account.setAccountName(renameAccountDto.accountName());

        accountRepository.save(account);

        return accountModelAssembler.toModel(account);
    }

    @Override
    public EntityModel<?> changeTransferLimitByUuid(String uuid, ChangeTransferLimitAccountDto changeTransferLimitAccountDto) {
        Account account = accountRepository.findAccountByUuid(uuid).orElseThrow();

        account.setTransferLimit(changeTransferLimitAccountDto.transferLimit());

        accountRepository.save(account);
        return accountModelAssembler.toModel(account);
    }

    @Override
    public String isDeleteAccountByUuid(String uuid, IsDeletedAccountDto isDeletedAccountDto) {
        Account account = accountRepository.findAccountByUuid(uuid).orElseThrow();

        account.setIsDeleted(isDeletedAccountDto.isDeleted());

        Account accountIsDeleted = accountRepository.save(account);

        return " Account is deleted "+ accountIsDeleted;
    }


}
