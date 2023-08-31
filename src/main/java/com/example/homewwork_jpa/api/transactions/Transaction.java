package com.example.homewwork_jpa.api.transactions;

import com.example.homewwork_jpa.api.account.Account;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    private String studentCardId;
    private String remark;
    private Timestamp transactionAt;
    @ManyToOne
    @JoinColumn(name = "sender_act_id")
    private Account senderAccId;
    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiverAccId;
    private Integer amount;
    private Boolean isPayment;
}
