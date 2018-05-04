package com.example.bookstore.domain.order;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import com.example.bookstore.domain.user.UserInfo;

import lombok.Data;

@Entity
@Data
@Table(name = "order_table")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToMany(mappedBy = "order")
  @Cascade(CascadeType.ALL)
  private List<BookOrder> bookOrders;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserInfo user;
  @CreationTimestamp
  private Date creationDate;

  @PostPersist
  public void populateOrderForBookOrders() {
    bookOrders.forEach(bookOrder -> {
      bookOrder.setOrder(this);
    });
  }
}
