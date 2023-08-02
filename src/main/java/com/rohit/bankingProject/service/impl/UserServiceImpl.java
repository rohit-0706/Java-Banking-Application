package com.rohit.bankingProject.service.impl;

import com.rohit.bankingProject.dto.AccountInfo;
import com.rohit.bankingProject.dto.BankResponse;
import com.rohit.bankingProject.dto.EmailDetails;
import com.rohit.bankingProject.dto.UserRequest;
import com.rohit.bankingProject.entity.User;
import com.rohit.bankingProject.repository.UserRepository;
import com.rohit.bankingProject.service.EmailService;
import com.rohit.bankingProject.service.UserService;
import com.rohit.bankingProject.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;



    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         *  Creating an account - saving a new user into the db
         *  Check id user already has an account
         */
        if(userRepository.existsByEmail(userRequest.getEmail())){
             return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();

        }

        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .email(userRequest.getEmail())
                .accountBalance(BigDecimal.ZERO)
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        User savedUser=userRepository.save(newUser);

        EmailDetails emailDetails = EmailDetails.builder()
                .subject("ACCOUNT CREATION")
                .recipient(savedUser.getEmail())
                .messageBody("Congratulations! Your Account has been successfully created.\n" +
                        "Your Account details are :\n" +
                        "Account Name : " + savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName() + "\n" +
                        "Account Number : " + savedUser.getAccountNumber()
                )

                .build();
        emailService.sendEmailAlert(emailDetails);


        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .build())
                .build();
    }
}
