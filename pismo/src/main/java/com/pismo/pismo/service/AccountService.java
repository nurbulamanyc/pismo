package com.pismo.pismo.service;

import com.pismo.pismo.entity.Account;
import com.pismo.pismo.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(String documentNumber) {
        Account account = new Account(documentNumber);
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public Optional<Account> getAccountByDocumentNumber(String documentNumber) {
        return accountRepository.findByDocumentNumber(documentNumber);
    }
}

