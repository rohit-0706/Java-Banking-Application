package com.rohit.bankingProject.service;

import com.rohit.bankingProject.dto.EmailDetails;

public interface EmailService {

    void sendEmailAlert(EmailDetails emailDetails);
}
