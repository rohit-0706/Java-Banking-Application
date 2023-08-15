package com.rohit.bankingProject.repository;

import com.rohit.bankingProject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
