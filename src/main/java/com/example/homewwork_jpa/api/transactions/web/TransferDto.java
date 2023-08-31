package com.example.homewwork_jpa.api.transactions.web;

import com.example.homewwork_jpa.api.account.Account;

import java.sql.Timestamp;

public record TransferDto(String uuid,
                          String studentCardId,
                          String remark,
                          Timestamp transactionAt,
                          Account senderAccId,
                          Account receiverAccId,
                          Integer amount,
                          Boolean isPayment) {
}
