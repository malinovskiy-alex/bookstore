package com.example.bookstore.domain.user;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserInfo user = userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("User is not found.");
    }
    return new BookstoreUserDetails(user.getEmail(), user.getPassword(), new ArrayList<>());
  }
}
