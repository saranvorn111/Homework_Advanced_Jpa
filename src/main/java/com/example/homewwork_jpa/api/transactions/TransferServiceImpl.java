package com.example.homewwork_jpa.api.transactions;

import com.example.homewwork_jpa.api.account.Account;
import com.example.homewwork_jpa.api.transactions.web.CreateTransactionDto;
import com.example.homewwork_jpa.api.transactions.web.TransferDto;
import com.example.homewwork_jpa.api.transactions.web.TransferMapper;
import com.example.homewwork_jpa.api.transactions.web.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper;


    @Transactional
    @Override
    public void transaction(CreateTransactionDto createTransactionDto) {

        transferRepository.transfer(createTransactionDto.senderAccountId(),
                createTransactionDto.receiverAccountId(),
                createTransactionDto.amount(),
                createTransactionDto.remark());

    }
}
