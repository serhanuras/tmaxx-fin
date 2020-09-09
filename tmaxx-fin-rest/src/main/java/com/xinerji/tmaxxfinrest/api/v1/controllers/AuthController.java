package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.JwtAuthenticationResponse;
import com.xinerji.tmaxxfindto.v1.LoginRequest;
import com.xinerji.tmaxxfindto.v1.SignUpRequest;
import com.xinerji.tmaxxfinrest.services.implementations.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    @ResponseStatus(OK)
    public JwtAuthenticationResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    @ResponseStatus(OK)
    public Long register(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }
}
