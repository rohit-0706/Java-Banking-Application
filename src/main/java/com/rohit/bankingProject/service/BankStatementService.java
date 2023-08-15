package com.rohit.bankingProject.service;

import com.rohit.bankingProject.entity.Transaction;

import java.util.List;

public interface BankStatementService {

    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate);
}
