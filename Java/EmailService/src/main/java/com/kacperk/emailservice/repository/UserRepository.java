package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.dtos.UserDto;
import com.kacperk.emailservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existByUsername(String username);

}
