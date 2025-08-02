package org.myfinanceapp.financeapp.controllers;

import org.myfinanceapp.financeapp.models.Transaction;
import org.myfinanceapp.financeapp.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/")
    public ResponseEntity<String> addTransaction(Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.status(201).body("Transaction added successfully.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTransaction(Transaction transaction) {
        transactionService.updateTransaction(transaction);
        return ResponseEntity.ok("Transaction updated successfully.");
    }

}
