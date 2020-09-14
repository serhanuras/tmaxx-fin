package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.AccountingPlanDto;
import com.xinerji.tmaxxfindto.v1.JwtAuthenticationDto;
import com.xinerji.tmaxxfindto.v1.LoginDto;
import com.xinerji.tmaxxfindto.v1.SignUpDto;
import com.xinerji.tmaxxfinrest.services.implementations.AuthService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(AuthController.BASE_URL)
@Slf4j
public class AuthController {
  public static final String BASE_URL = "/api/v1/auth";

  private AuthService authService;

  @Autowired
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @ApiOperation(
      value = "Login end point which provides JWT token to use other APIs.",
      notes = "Login end point which provides JWT token to use other APIs.")
  @ApiResponses({
    @ApiResponse(code = 200, response = JwtAuthenticationDto.class, message = "Jwt Token returns"),
  })
  @PostMapping("/signin")
  @ResponseStatus(HttpStatus.OK)
  public JwtAuthenticationDto login(@Valid @RequestBody LoginDto loginRequest) {
    return authService.authenticateUser(loginRequest);
  }

  @ApiOperation(
      value = "Login end point which provides JWT token to use other APIs.",
      notes = "Login end point which provides JWT token to use other APIs.")
  @ApiResponses({
    @ApiResponse(code = 200, response = JwtAuthenticationDto.class, message = "Jwt Token returns"),
  })
  @PostMapping("/signup")
  @ResponseStatus(HttpStatus.OK)
  public Long register(@Valid @RequestBody SignUpDto signUpRequest) {
    return authService.registerUser(signUpRequest);
  }
}
