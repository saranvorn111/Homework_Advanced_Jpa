package com.example.homewwork_jpa.entity.api.account.web;

import com.example.homewwork_jpa.entity.api.account.Account;
import com.example.homewwork_jpa.entity.api.account.AccountService;
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
    public EntityModel<?> updateAccount(@PathVariable String uuid,@RequestBody UpdateAccountDto updateAccountDto){
        return accountService.renameAccountByUuid(uuid,updateAccountDto);

    }

}
