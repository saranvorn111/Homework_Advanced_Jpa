package com.example.homewwork_jpa.entity.api.account;

import com.example.homewwork_jpa.entity.api.accountType.AccountType;
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
    private Integer transferLimit;
   @ManyToOne
   @JoinColumn(name = "account_type")
    private AccountType accountType;
}
