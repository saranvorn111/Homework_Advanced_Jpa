package com.example.homewwork_jpa.api.account.web;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Relation(collectionRelation = "Accounts",itemRelation = "account")
public record AccountDto(String uuid,
                         String accountName,
                         Integer transferLimit) {
}
