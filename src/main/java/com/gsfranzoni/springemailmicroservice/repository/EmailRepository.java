package com.gsfranzoni.springemailmicroservice.repository;

import com.gsfranzoni.springemailmicroservice.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
