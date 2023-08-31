package com.example.homewwork_jpa.api.account.web;

import lombok.Builder;

@Builder
public record CreateAccountDto(
        String uuid,
        String accountName,
        String accountNo,
        String pin,
        Integer transferLimit) {
}
