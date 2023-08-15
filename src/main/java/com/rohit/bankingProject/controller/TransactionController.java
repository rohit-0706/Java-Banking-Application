package com.rohit.bankingProject.controller;

import com.rohit.bankingProject.dto.BankResponse;
import com.rohit.bankingProject.entity.Transaction;
import com.rohit.bankingProject.service.BankStatementService;
import com.rohit.bankingProject.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankStatement")
@AllArgsConstructor
public class TransactionController {

    @Autowired
    BankStatementService bankStatementService;

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<Transaction> generateBankStatement(@RequestParam String accountNumber,
                                                   @RequestParam String startDate ,
                                                   @RequestParam String endDate){
        return bankStatementService.generateStatement(accountNumber,startDate,endDate);

    }
}
