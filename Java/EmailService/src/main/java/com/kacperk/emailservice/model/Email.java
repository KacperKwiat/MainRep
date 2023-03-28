package com.kacperk.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="Email")
public class Email {
    @Id
    @GeneratedValue
    @Column(name="email_id")
    private Long id;
    @Column(name="sent_time")
    private LocalDateTime dateTime;
    @Column(name="message")
    private String message;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_inbox", referencedColumnName = "email_id")
    private List<User> recivingUsers;

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
