package com.ritesh.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.boot.entity.Book;
import com.ritesh.boot.persistence.BookRepository;

@RestController
public class BookRestController {

	/*
	 * POST/book: It creates a book.
	 * 
	 * GET/book/{id}: It retrieves the detail of a book.
	 * 
	 * GET/book: It retrieves the detail of all books.
	 * 
	 * PUT/book: To update a book
	 * 
	 * DELETE/book/{id}: It deletes a book.
	 * 
	 * DELETE/book: It deletes all books.
	 */

	@Autowired
	Book book;

	@Autowired
	BookRepository repository;

	Logger logger = LoggerFactory.getLogger(BookRestController.class);

	@PostMapping(path = "/book")
	public Book addBook(@ModelAttribute("book") Book tempBook) {
		book = tempBook;

		repository.save(book);
		logger.debug("added new book named: "+ tempBook.getName());
		return book;
	} // while colling provide data in Key-value pair of body
	
	
}
