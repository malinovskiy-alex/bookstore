package com.example.bookstore.config.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.example.bookstore.domain.user.Gender;
import com.example.bookstore.domain.user.UserInfo;

@Configuration
public class DataRestConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.exposeIdsFor(Gender.class, UserInfo.class);
  }
}
