package com.example.homewwork_jpa.api.account.web;

import com.example.homewwork_jpa.api.account.Account;
import com.example.homewwork_jpa.api.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public CollectionModel<?>findAllAccount(){
        return accountService.finAllAccount();

    }
    @GetMapping("/{uuid}")
    public EntityModel<?> findAccountByUuid(@PathVariable String uuid){
        return accountService.findAccountByUuid(uuid);

    }
    @PostMapping
    public Account createNewAccount(@RequestBody CreateAccountDto createAccountDto){

        return accountService.createAccount(createAccountDto);
    }

    @PutMapping("/{uuid}/rename")
    public EntityModel<?> updateAccount(@PathVariable String uuid,@RequestBody RenameAccountDto renameAccountDto){
        return accountService.renameAccountByUuid(uuid,renameAccountDto);

    }
    @PostMapping("/{uuid}/limit-transfer")
    public EntityModel<?> changeTransferLimit(@PathVariable String uuid,@RequestBody ChangeTransferLimitAccountDto changeTransferLimitAccountDto){
        return accountService.changeTransferLimitByUuid(uuid,changeTransferLimitAccountDto);
    }
    @PutMapping("/{uuid}/close")
    public String isDeleteAccount(@PathVariable String uuid,@RequestBody IsDeletedAccountDto isDeletedAccountDto){
        return accountService.isDeleteAccountByUuid(uuid,isDeletedAccountDto);
    }

}
