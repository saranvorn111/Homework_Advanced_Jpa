package com.example.homewwork_jpa.entity.api.user.web;

import com.example.homewwork_jpa.entity.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUuid(String uuid);
}
