package com.pismo.pismo.service;

import com.pismo.pismo.entity.Account;
import com.pismo.pismo.entity.OperationType;
import com.pismo.pismo.entity.Transaction;
import com.pismo.pismo.repository.AccountRepository;
import com.pismo.pismo.repository.OperationTypeRepository;
import com.pismo.pismo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final OperationTypeRepository operationTypeRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              OperationTypeRepository operationTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.operationTypeRepository = operationTypeRepository;
    }

    public Optional<Transaction> createTransaction(Long accountId, Long operationTypeId, BigDecimal amount) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isPresent()) {
            OperationType type = operationTypeRepository.save(new OperationType(operationTypeId));
            Transaction transaction = new Transaction(account.get(), type, amount);
            transaction.setEventDate(LocalDateTime.now());
            return Optional.of(transactionRepository.save(transaction));
        }

        return Optional.empty();
    }

    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.map(transactionRepository::findByAccount).orElse(Collections.emptyList());
    }

    public BigDecimal getAccountBalance(Long accountId) {
        List<Transaction> transactions = getTransactionsByAccountId(accountId);
        return transactions.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

