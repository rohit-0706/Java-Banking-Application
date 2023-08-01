package com.rohit.bankingProject.service;

import com.rohit.bankingProject.dto.BankResponse;
import com.rohit.bankingProject.dto.UserRequest;

public interface UserService {
    BankResponse createAccount(UserRequest userRequest);
}
