package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
