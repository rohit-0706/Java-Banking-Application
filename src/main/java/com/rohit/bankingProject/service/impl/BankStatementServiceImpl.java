package com.rohit.bankingProject.service.impl;

import com.rohit.bankingProject.entity.Transaction;
import com.rohit.bankingProject.repository.TransactionRepository;
import com.rohit.bankingProject.service.BankStatementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
@AllArgsConstructor
@Component
public class BankStatementServiceImpl implements BankStatementService {

    @Autowired
    TransactionRepository transactionRepository;

    /**
     * retrieve list of transactions within a date range given an account number
     * generate a pdf file of transactions
     * send the file via email
     */


    @Override
    public List<Transaction> generateStatement(String accountNumber, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDate,DateTimeFormatter.ISO_DATE);


        /**
         * In this method first I'm fetching all the transaction and then filtering
         *
         * List<Transaction> transactionList = transactionRepository.findAll();
         *         transactionList = transactionList.stream()
         *                 .filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
         *                 .filter(transaction -> ((transaction.getCreatedAt() != null) && (transaction.getCreatedAt().isAfter(start)
         *                         || transaction.getCreatedAt().isEqual(start))
         *                         &&  (transaction.getCreatedAt().isBefore(end)
         *                         || transaction.getCreatedAt().isEqual(end))))
         *                 .toList();
         */


        /**
         * In this method I'm fetching only accountNumber through JPA and then filtering
         *
         * transactionList = transactionRepository.findByAccountNumber(accountNumber);
         *         List<Transaction> newTransactionList = transactionList.stream()
         *                 .filter(transaction -> ((transaction.getCreatedAt().isAfter(start)
         *                         || transaction.getCreatedAt().isEqual(start))
         *                         &&  (transaction.getCreatedAt().isBefore(end)
         *                         || transaction.getCreatedAt().isEqual(end))))
         *                 .toList();
         */

        List<Transaction> transactionList2 = transactionRepository.findByAccountNumberAndCreatedAtBetween(accountNumber, start, end);

        return transactionList2;

    }
}
