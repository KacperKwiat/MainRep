package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.dtos.EmailDto;
import com.kacperk.emailservice.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
