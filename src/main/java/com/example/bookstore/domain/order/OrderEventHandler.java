package com.example.bookstore.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bookstore.domain.user.UserRepository;

@RepositoryEventHandler(Order.class)
public class OrderEventHandler {

  @Autowired
  private UserRepository userRepository;

  @HandleBeforeCreate
  public void handlerOrderSave(Order order) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    order.setUser(userRepository.findByEmail(((UserDetails) (authentication.getPrincipal())).getUsername()));
  }
}
