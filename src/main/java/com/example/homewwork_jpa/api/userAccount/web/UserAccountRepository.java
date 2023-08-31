package com.example.homewwork_jpa.api.userAccount.web;

import com.example.homewwork_jpa.api.userAccount.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {
    List<UserAccount> findByUserUuid(String uuid);
    Optional<UserAccount>  findByUser_UuidAndAccount_Uuid(String userUuid, String accountUuid);
}
