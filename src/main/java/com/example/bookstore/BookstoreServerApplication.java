package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class BookstoreServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreServerApplication.class, args);
	}
}
