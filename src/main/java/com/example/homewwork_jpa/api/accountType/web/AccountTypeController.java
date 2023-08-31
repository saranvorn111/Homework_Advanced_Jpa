package com.example.homewwork_jpa.api.accountType.web;

import com.example.homewwork_jpa.api.accountType.AccountType;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeController {
    private final AccountTypeRepository accountTypeRepository;
    @GetMapping
    public List<AccountTypeDto> getAllAccountType(){
       List<AccountTypeDto> accountTypeDto =  accountTypeRepository.findAllAccountTypes();

       return accountTypeDto;

    }
    @GetMapping("/{id}")
    public AccountTypeDto getAccountTypeById(@PathVariable Integer id){
        AccountTypeDto accountTypeDto = accountTypeRepository.findAccountTypeById(id);
        return accountTypeDto;
    }
}
