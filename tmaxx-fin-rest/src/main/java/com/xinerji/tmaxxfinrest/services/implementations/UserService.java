package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfindto.v1.UserSummary;
import com.xinerji.tmaxxfinrest.utils.UserPrincipal;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserSummary getCurrentUser(UserPrincipal userPrincipal) {
        return UserSummary.builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .name(userPrincipal.getName())
                .build();
    }
}
