package com.xinerji.tmaxxfinrest.api.v1.controllers;

import com.xinerji.tmaxxfindto.v1.JwtAuthenticationDto;
import com.xinerji.tmaxxfindto.v1.UserSummaryDto;
import com.xinerji.tmaxxfinrest.services.implementations.UserService;
import com.xinerji.tmaxxfinrest.utils.CurrentUser;
import com.xinerji.tmaxxfinrest.utils.UserPrincipal;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.BASE_URL)
@Slf4j
public class UserController {
  public static final String BASE_URL = "/api/v1/users";

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @ApiOperation(value = "Returns current user info", notes = "Returns current user info.")
  @ApiResponses({
    @ApiResponse(code = 200, response = JwtAuthenticationDto.class, message = "Jwt Token returns"),
  })
  @GetMapping("me")
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('USER')")
  public UserSummaryDto getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    return userService.getCurrentUser(currentUser);
  }
}
