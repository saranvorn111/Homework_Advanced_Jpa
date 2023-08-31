package com.example.homewwork_jpa.api.transactions;

import com.example.homewwork_jpa.api.transactions.web.CreateTransactionDto;

public interface TransferService {
    void transaction(CreateTransactionDto createTransactionDto);
}
