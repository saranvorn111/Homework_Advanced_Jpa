package com.example.homewwork_jpa.api.user.web;

import com.example.homewwork_jpa.api.account.Account;
import com.example.homewwork_jpa.api.accountType.web.AccountTypeRepository;
import com.example.homewwork_jpa.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUuid(String uuid);

    @Modifying
    @Query("DELETE FROM User u WHERE u.uuid = :uuid")
    void deleteUserByUuid(String uuid);


}
