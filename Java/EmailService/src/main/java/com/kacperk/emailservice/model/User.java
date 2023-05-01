package com.kacperk.emailservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="password", nullable = false, length = 64)
    private String password;
    @Column(name="gender")
    private Gender gender;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_address_ID")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_userEmails", referencedColumnName = "email_id")
    private Email user_email;
    @Column(name = "emailName", nullable = false, unique = true)
    private String emailName;

    public Email getUser_email() {
        return user_email;
    }

    public void setUser_email(Email user_email) {
        this.user_email = user_email;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
