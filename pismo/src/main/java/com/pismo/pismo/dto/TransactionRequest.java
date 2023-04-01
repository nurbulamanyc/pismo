package com.pismo.pismo.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Long accountId;
    private Long operationTypeId;
    private BigDecimal amount;
}
