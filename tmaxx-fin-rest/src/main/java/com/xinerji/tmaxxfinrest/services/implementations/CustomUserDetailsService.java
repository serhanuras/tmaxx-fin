package com.xinerji.tmaxxfinrest.services.implementations;

import com.xinerji.tmaxxfinrest.data.model.User;
import com.xinerji.tmaxxfinrest.data.repositories.UserRepository;
import com.xinerji.tmaxxfinrest.expections.ResourceNotFoundException;
import com.xinerji.tmaxxfinrest.utils.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private UserRepository userRepository;

  @Autowired
  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(
                () -> new ResourceNotFoundException("User not found [email: " + email + "]"));

    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found [id: " + id + "]"));

    return UserPrincipal.create(user);
  }
}
