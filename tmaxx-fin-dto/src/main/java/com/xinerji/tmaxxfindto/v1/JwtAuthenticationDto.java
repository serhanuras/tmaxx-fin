package com.xinerji.tmaxxfindto.v1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationDto {
  private String accessToken;
  private String tokenType = "Bearer";

  public JwtAuthenticationDto(String accessToken) {
    this.accessToken = accessToken;
  }
}
