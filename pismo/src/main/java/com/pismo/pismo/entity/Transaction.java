package com.pismo.pismo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    private Account account;

    @ManyToOne
    private OperationType operationType;

    private BigDecimal amount;
    private LocalDateTime eventDate;

    public Transaction(Account account, OperationType operationType, BigDecimal amount) {
        this.account = account;
        this.operationType = operationType;
        this.amount = amount;
    }
}