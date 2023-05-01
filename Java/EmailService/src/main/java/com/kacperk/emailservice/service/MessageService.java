package com.kacperk.emailservice.service;

import com.kacperk.emailservice.model.Message;
import com.kacperk.emailservice.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;



}
