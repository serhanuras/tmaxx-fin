package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfindto.v1.UserSummaryDto;
import com.xinerji.tmaxxfinrest.utils.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public UserSummaryDto getCurrentUser(UserPrincipal userPrincipal) {
    return UserSummaryDto.builder()
        .id(userPrincipal.getId())
        .email(userPrincipal.getEmail())
        .name(userPrincipal.getName())
        .build();
  }
}
