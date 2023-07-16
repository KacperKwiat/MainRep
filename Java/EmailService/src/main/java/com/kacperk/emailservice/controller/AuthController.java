package com.kacperk.emailservice.controller;

import com.kacperk.emailservice.dtos.RegisterDto;
import com.kacperk.emailservice.dtos.UserDto;
import com.kacperk.emailservice.model.Role;
import com.kacperk.emailservice.model.User;
import com.kacperk.emailservice.repository.RoleRepository;
import com.kacperk.emailservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String>register(@RequestBody RegisterDto registerDto ){
        if (userRepository.existByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("Username is already taken.", HttpStatus.BAD_REQUEST);
        }
        UserDto userDto= UserDto.builder().name(registerDto.getName())
                .surname(registerDto.getSurname())
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword())).build();

        Role role=roleRepository.findByName("USER").get();
        userDto.setRoles(Collections.singletonList(role));

        User createdUser=new User();
        BeanUtils.copyProperties(userDto, createdUser);

        return new ResponseEntity<>("User successfully created", HttpStatus.ACCEPTED);
    }
}
