package com.example.homewwork_jpa.init;

import com.example.homewwork_jpa.entity.api.account.Account;
import com.example.homewwork_jpa.entity.api.account.web.AccountRepository;
import com.example.homewwork_jpa.entity.api.accountType.AccountType;
import com.example.homewwork_jpa.entity.api.accountType.web.AccountTypeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitialization {

    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;

    @PostConstruct
    void init(){
        System.out.println("Hello everyone");

        AccountType accountType1 = AccountType.builder()
                .name("Saving")
                .build();
        AccountType accountType2 = AccountType.builder()
                .name("Pay")
                .build();

        accountTypeRepository.saveAll(List.of(accountType1,accountType2));


        Account account1 = Account.builder()
                .uuid(UUID.randomUUID().toString())
                .pin("1111")
                .accountName("Saran")
                .accountNo("001")
                .transferLimit(2000)
                .accountType(accountType2)
                .build();
        Account account2 = Account.builder()
                .uuid(UUID.randomUUID().toString())
                .pin("2222")
                .accountName("SokRoth")
                .accountNo("002")
                .transferLimit(1000)
                .accountType(accountType1)
                .build();
        accountRepository.saveAll(List.of(account1,account2));

        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(account-> System.out.println(account.getAccountName()));



    }
}
