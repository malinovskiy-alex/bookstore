package com.example.bookstore.domain.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bookstore.deserializer.BirthdayDateDeserializer;
import com.example.bookstore.serializer.BirthdayDateSerializer;
import com.example.bookstore.serializer.GenderSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;
  private String password;
  @JsonSerialize(using = BirthdayDateSerializer.class)
  @JsonDeserialize(using = BirthdayDateDeserializer.class)
  private LocalDate birthday;
  @OneToOne
  @JoinColumn(name = "gender_id")
  @JsonSerialize(using = GenderSerializer.class)
  private Gender gender;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
