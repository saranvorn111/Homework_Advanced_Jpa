package com.example.homewwork_jpa.api.transactions.web;

import com.example.homewwork_jpa.api.transactions.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {
    Transaction mapTransferToTransferDto(CreateTransactionDto createTransactionDto);

}
