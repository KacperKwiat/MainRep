package com.kacperk.emailservice.repository;

import com.kacperk.emailservice.dtos.UserDto;
import com.kacperk.emailservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
