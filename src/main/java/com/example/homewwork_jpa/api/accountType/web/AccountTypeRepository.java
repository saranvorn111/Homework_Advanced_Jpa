package com.example.homewwork_jpa.api.accountType.web;

import com.example.homewwork_jpa.api.accountType.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {

    @Query("select new com.example.homewwork_jpa.api.accountType.web.AccountTypeDto(a.name) from AccountType a")
    List<AccountTypeDto> findAllAccountTypes();

    @Query("select new com.example.homewwork_jpa.api.accountType.web.AccountTypeDto(a.name) from AccountType a where a.id= :id")
    AccountTypeDto findAccountTypeById(Integer id);
}
