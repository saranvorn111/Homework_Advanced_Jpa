package com.example.homewwork_jpa.api.account;

import com.example.homewwork_jpa.api.accountType.AccountType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String pin;
    private String accountNo;
    private String accountName;
    private Boolean isDeleted;
    private Integer transferLimit;
    private Integer balance;
   @ManyToOne
   @JoinColumn(name = "account")
    private AccountType accountType;
}
