package com.kacperk.emailservice.dtos;

import com.kacperk.emailservice.model.Address;
import com.kacperk.emailservice.model.Email;
import com.kacperk.emailservice.model.Gender;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String emailName;

    private Gender gender;
    private Address address;
    private List<Email> sent_Emails;

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
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

    public List<Email> getSent_Emails() {
        return sent_Emails;
    }

    public void setSent_Emails(List<Email> sent_Emails) {
        this.sent_Emails = sent_Emails;
    }
}
