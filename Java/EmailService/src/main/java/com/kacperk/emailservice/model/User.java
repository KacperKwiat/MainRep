package com.kacperk.emailservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="user")
public class User implements UserDetails {
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
    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.emailName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }
}
