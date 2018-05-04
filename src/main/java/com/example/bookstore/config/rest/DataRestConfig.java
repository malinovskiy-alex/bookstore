package com.example.bookstore.config.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.example.bookstore.domain.book.Book;
import com.example.bookstore.domain.order.OrderEventHandler;
import com.example.bookstore.domain.user.Gender;
import com.example.bookstore.domain.user.UserInfo;

@Configuration
public class DataRestConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Gender.class, UserInfo.class, Book.class);
  }

  @Bean
  OrderEventHandler orderEventHandler() {
    return new OrderEventHandler();
  }
}
