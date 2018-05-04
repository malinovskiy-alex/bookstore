package com.example.bookstore.domain.user;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.bookstore.deserializer.BirthdayDateDeserializer;
import com.example.bookstore.domain.order.Order;
import com.example.bookstore.serializer.BirthdayDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;
  @JsonIgnore
  private String password;
  @JsonSerialize(using = BirthdayDateSerializer.class)
  @JsonDeserialize(using = BirthdayDateDeserializer.class)
  private LocalDate birthday;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "gender_id")
  private Gender gender;
  @OneToMany(mappedBy = "user")
  private List<Order> orders;
}
