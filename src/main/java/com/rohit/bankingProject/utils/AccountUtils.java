package com.rohit.bankingProject.utils;

import jakarta.servlet.http.PushBuilder;

import java.time.Year;

public class AccountUtils {


    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This User already has an account Created";
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "User is not exist with the given info";
    public static final String ACCOUNT_FOUND_CODE = "004";
    public static final String ACCOUNT_FOUND_SUCCESS = "User Account Found";
    public static final String ACCOUNT_CREDITED_SUCCESS = "005";
    public static final String ACCOUNT_CREDITED_SUCCESS_MESSAGE = "User Account Credited Successfully";
    public static final String INSUFFICIENT_BALANCE_CODE = "006";
    public static final String INSUFFICIENT_BALANCE_MESSAGE = "Insufficient Balance in your Account";
    public static final String ACCOUNT_DEBITED_SUCCESSFULLY = "007";
    public static final String ACCOUNT_DEBITED_SUCCESSFULLY_MESSAGE = "User Account Debited Successfully";
    public static final String DESTINATION_ACCOUNT_NOT_FOUND = "008";
    public static final String DESTINATION_ACCOUNT_NOT_FOUNT_MESSAGE = "Destination account not found";
    public static final String SOURCE_ACCOUNT_NOT_FOUND = "009";
    public static final String SOURCE_ACCOUNT_NOT_FOUNT_MESSAGE = "Source account not found";
    public static final String TRANSFER_SUCCESSFUL = "010";
    public static final String TRANSFER_SUCCESSFUL_MESSAGE = "Transfer Completed Successfully";

    public static String generateAccountNumber(){
        /**
         * 2023 + Random six digit number
         */
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        //generate a random number between min and max
        int randNumber = (int) Math.floor(Math.random() * (max-min+1)+min);

        //convert the value of current year and random integer into string then concatenate
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(randomNumber).toString();
    }


}
