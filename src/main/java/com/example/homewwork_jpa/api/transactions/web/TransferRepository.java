package com.example.homewwork_jpa.api.transactions.web;

import com.example.homewwork_jpa.api.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface TransferRepository extends JpaRepository<Transaction,Integer> {
    @Procedure
    void transfer(
            @Param("sender") Integer sender,
            @Param("receiver") Integer receiver,
            @Param("amount") Integer amount,
            @Param("remark") String remark
    );

}
