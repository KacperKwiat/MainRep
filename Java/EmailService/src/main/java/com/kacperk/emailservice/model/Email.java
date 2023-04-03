package com.kacperk.emailservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="email_id")
    private Long id;
    @Column(name="emailName", nullable = false, unique = true)
    private String emailName;

    @OneToOne(mappedBy ="user_email" )
    private User user;

    @OneToOne(mappedBy = "sender")
    private Message message;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
