package com.kacperk.emailservice.model;

import javax.persistence.*;

@Table(name="Adress")
public class Address {
    @Id
    @GeneratedValue
    @Column(name="address_id")
    private Long id;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="postal code")
    private String postal_code;
    @Column(name="street")
    private String street;
    @Column(name="apartment-number")
    private Long number;

    @OneToOne(mappedBy ="address")
    private User user;


    public Address(String country, String city, String postal_code, String street, Long number) {

        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
        this.number = number;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
