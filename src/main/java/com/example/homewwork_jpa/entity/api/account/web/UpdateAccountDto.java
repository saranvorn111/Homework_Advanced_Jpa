package com.example.homewwork_jpa.entity.api.account.web;

import lombok.Builder;

@Builder
public record UpdateAccountDto(
        String uuid,
        String accountName,
        Integer transferLimit) {
}
