package com.example.homewwork_jpa.entity.api.account.web;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Relation(collectionRelation = "Accounts",itemRelation = "account")
public record AccountDto(String uuid,
                         String accountName,
                         String accountNo,
                         Integer transferLimit) {
}
