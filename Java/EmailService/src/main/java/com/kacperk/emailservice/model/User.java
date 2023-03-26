package com.kacperk.emailservice.model;

import javax.persistence.*;
import java.util.List;

@Table(name="User")
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="gender")
    private Gender gender;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_addressID")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_fromEmail", referencedColumnName = "user_id")
    private List<Email> sent_emails;



    public User(String name, String surname, Gender gender, Address address) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
    }

    public User() {
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
