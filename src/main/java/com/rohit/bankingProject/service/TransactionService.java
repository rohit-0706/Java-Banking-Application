package com.rohit.bankingProject.service;

import com.rohit.bankingProject.dto.TransactionDto;
import com.rohit.bankingProject.entity.Transaction;

public interface TransactionService {

    void saveTransaction(TransactionDto transactionDto);
}
