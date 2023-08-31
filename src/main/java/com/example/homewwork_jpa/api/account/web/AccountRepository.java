package com.example.homewwork_jpa.api.account.web;

import com.example.homewwork_jpa.api.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findAccountByUuid(String uuid);
}
