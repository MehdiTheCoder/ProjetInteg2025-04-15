package com.dailyride.controller;

import com.dailyride.dto.AuthResponse;
import com.dailyride.dto.RegisterRequest;
import com.dailyride.dto.LoginRequest;
import com.dailyride.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestAuthController {
    
    private final AuthService authService;

    @PostMapping("/register-owner")
    public ResponseEntity<AuthResponse> registerTestOwner() {
        RegisterRequest request = RegisterRequest.builder()
                .name("John Doe")
                .email("john@example.com")
                .password("password123")
                .role("OWNER")
                .build();
        
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/register-customer")
    public ResponseEntity<AuthResponse> registerTestCustomer() {
        RegisterRequest request = RegisterRequest.builder()
                .name("Jane Doe")
                .email("jane@example.com")
                .password("password123")
                .role("CUSTOMER")
                .build();
        
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login-owner")
    public ResponseEntity<AuthResponse> loginTestOwner() {
        LoginRequest request = LoginRequest.builder()
                .email("john@example.com")
                .password("password123")
                .build();
        
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/login-customer")
    public ResponseEntity<AuthResponse> loginTestCustomer() {
        LoginRequest request = LoginRequest.builder()
                .email("jane@example.com")
                .password("password123")
                .build();
        
        return ResponseEntity.ok(authService.login(request));
    }
} 