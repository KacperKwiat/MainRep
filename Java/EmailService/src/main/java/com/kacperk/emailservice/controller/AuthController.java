package com.kacperk.emailservice.controller;

import com.kacperk.emailservice.model.AuthenticationResponse;
import com.kacperk.emailservice.repository.RoleRepository;
import com.kacperk.emailservice.repository.UserRepository;
import com.kacperk.emailservice.model.AuthenticationRequest;
import com.kacperk.emailservice.model.RegisterRequest;
import com.kacperk.emailservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(authService.register(registerRequest));
    }



    @PostMapping("/log")
    public ResponseEntity<AuthenticationResponse>authenticate(@RequestBody AuthenticationRequest authenticationRequest ){
        return ResponseEntity.ok(authService.authenticate(authenticationRequest));
    }

}
