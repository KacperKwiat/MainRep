package com.kacperk.emailservice.dtos;

import com.kacperk.emailservice.model.Message;
import com.kacperk.emailservice.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EmailDto {
    private Long id;
    private String title;
    private LocalDateTime dateTime;
    private Message message;
    private List<User> recivingUsers;

    public EmailDto(Long id, String title, LocalDateTime dateTime, Message message, List<User> recivingUsers) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
        this.message = message;
        this.recivingUsers = recivingUsers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<User> getRecivingUsers() {
        return recivingUsers;
    }

    public void setRecivingUsers(List<User> recivingUsers) {
        this.recivingUsers = recivingUsers;
    }
}
