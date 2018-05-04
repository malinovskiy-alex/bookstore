package com.example.bookstore.domain.order;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.bookstore.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "book_order")
@AllArgsConstructor
@NoArgsConstructor
public class BookOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "book_id")
  private Book book;
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;
  private int count;
  private BigDecimal price;
}
