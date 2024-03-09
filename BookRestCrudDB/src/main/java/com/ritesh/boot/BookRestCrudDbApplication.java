package com.ritesh.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ritesh.boot.persistence.BookRepository;

@SpringBootApplication
public class BookRestCrudDbApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookRestCrudDbApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);

		// The code is written to test DB connection
		/*
		 * Book book = new Book(); book.setName("The Java");
		 * book.setAuthor("Ritesh Singh"); book.setPublication("Basistha publication");
		 * book.setPrice(255.50);
		 * 
		 * bookRepository.save(book);
		 */
	}
}
