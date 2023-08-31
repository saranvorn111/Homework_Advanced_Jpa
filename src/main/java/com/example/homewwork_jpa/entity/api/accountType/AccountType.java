package com.example.homewwork_jpa.entity.api.accountType;

import com.example.homewwork_jpa.entity.api.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "account_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "accountType")
    private List<Account> accounts;

}
