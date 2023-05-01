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
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;


    @Column(name="message", length = 350)
    private String message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_sender_id")
    private Email sender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_inbox", referencedColumnName = "message_id", nullable = false)
    private List<Email> recivingEmails =new ArrayList<>();


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
