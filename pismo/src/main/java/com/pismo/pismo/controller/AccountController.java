package com.pismo.pismo.controller;

import com.pismo.pismo.dto.AccountRequest;
import com.pismo.pismo.entity.Account;
import com.pismo.pismo.exception.ResourceNotFoundException;
import com.pismo.pismo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountRequest accountRequest) {
        Account account = accountService.createAccount(accountRequest.getDocumentNumber());
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + accountId));
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<Account> getAccountById(@PathVariable String documentNumber) {
        return accountService.getAccountByDocumentNumber(documentNumber)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with documentNumber: " + documentNumber));
    }
}

