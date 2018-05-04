package com.example.bookstore.domain.order;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.book.Book;
import com.example.bookstore.domain.user.UserInfo;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private OrderRepository orderRepository;

  @Before
  public void init() throws ParseException {
    UserInfo userInfo = new UserInfo();
    userInfo.setEmail("malinovskiy-alex@ukr.net");
    entityManager.persist(userInfo);
    Book book1 = new Book();
    book1.setName("Book1");
    book1.setPrice(new BigDecimal(100));
    Book book2 = new Book();
    book2.setName("Book2");
    book2.setPrice(new BigDecimal(300));
    Order order = new Order();
    order.setUser(userInfo);
    BookOrder bookOrder1 = new BookOrder();
    bookOrder1.setPrice(new BigDecimal(100));
    bookOrder1.setBook(book1);

    BookOrder bookOrder2 = new BookOrder();
    bookOrder2.setPrice(new BigDecimal(300));
    bookOrder2.setBook(book2);

    order.setBookOrders(Arrays.asList(bookOrder1, bookOrder2));

    entityManager.persist(order);
    entityManager.flush();
  }

  @Test
  public void testManyToManySave() {
    Order one = orderRepository.getOne(1L);
    assertEquals(2, one.getBookOrders().size());
  }

}
