package com.kacperk.emailservice.dtos;

import com.kacperk.emailservice.model.Email;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class MessageDto {

    private Long id;

    private String message;
    private Email sender;
    private List<Email>recivers=new ArrayList<>();

    public MessageDto(Long id,  String message, Email sender, List<Email> recivers) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.recivers = recivers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Email getSender() {
        return sender;
    }

    public void setSender(Email sender) {
        this.sender = sender;
    }

    public List<Email> getRecivers() {
        return recivers;
    }

    public void setRecivers(List<Email> recivers) {
        this.recivers = recivers;
    }
}
