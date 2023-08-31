package com.example.homewwork_jpa.api.account.web;

import lombok.Builder;

@Builder
public record RenameAccountDto(String accountName) {
}
