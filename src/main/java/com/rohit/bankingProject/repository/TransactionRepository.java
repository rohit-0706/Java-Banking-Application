package com.rohit.bankingProject.repository;

import com.rohit.bankingProject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findByAccountNumber(String accountNumber);
}
