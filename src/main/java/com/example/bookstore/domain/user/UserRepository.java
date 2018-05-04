package com.example.bookstore.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends JpaRepository<UserInfo, Long> {

  @RestResource(exported = false)
  UserInfo findByEmail(String email);
}
