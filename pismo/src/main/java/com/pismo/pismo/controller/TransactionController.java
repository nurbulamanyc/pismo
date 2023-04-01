package com.pismo.pismo.controller;

import com.pismo.pismo.dto.TransactionRequest;
import com.pismo.pismo.entity.Transaction;
import com.pismo.pismo.exception.ResourceNotFoundException;
import com.pismo.pismo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return transactionService.createTransaction(transactionRequest.getAccountId(),
                transactionRequest.getOperationTypeId(), transactionRequest.getAmount())
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Account or Operation Type not found"));
    }
}

