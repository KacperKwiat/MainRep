package com.kacperk.emailservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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





}
