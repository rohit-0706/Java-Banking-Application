package com.rohit.bankingProject.repository;

import com.rohit.bankingProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   Boolean existsByEmail(String email);
}