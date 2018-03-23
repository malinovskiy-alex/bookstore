package com.example.bookstore.domain.role;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.example.bookstore.domain.permission.Permission;

import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String description;
  @ManyToMany
  @JoinTable(
    name = "role_permission",
    joinColumns = {@JoinColumn(name = "role_id")},
    inverseJoinColumns = {@JoinColumn(name = "permission_id")}
  )
  private Set<Permission> permissions;
}
