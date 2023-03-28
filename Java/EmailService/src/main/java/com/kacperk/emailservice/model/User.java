package com.kacperk.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="emailName", nullable = false, unique = true)
    private String emailName;
    @Column(name="password", nullable = false, length = 64)
    private String password;
    @Column(name="gender")
    private Gender gender;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_addressID")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_fromEmail", referencedColumnName = "user_id")
    private List<Email> sent_emails;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public List<Email> getSent_emails() {
        return sent_emails;
    }

    public void setSent_emails(List<Email> sent_emails) {
        this.sent_emails = sent_emails;
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
