package com.kacperk.emailservice.dtos;

import com.kacperk.emailservice.model.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EmailDto {
    private Long id;
    private String topic;
    private LocalDateTime dateTime;
    private String message;
    private List<User> recivingUsers;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public List<User> getRecivingUsers() {
        return recivingUsers;
    }

    public void setRecivingUsers(List<User> recivingUsers) {
        this.recivingUsers = recivingUsers;
    }
}
