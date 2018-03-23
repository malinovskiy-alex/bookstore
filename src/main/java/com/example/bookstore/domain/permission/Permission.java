package com.example.bookstore.domain.permission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "permission")
public class Permission {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String description;
}
