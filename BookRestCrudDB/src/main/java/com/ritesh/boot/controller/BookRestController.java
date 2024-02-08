package com.ritesh.boot.controller;

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

	@PostMapping(path = "/book")
	public Book addBook(@ModelAttribute("book") Book tempBook) {
		book = tempBook;

		repository.save(book);

		return book;
	} // while colling provide data in Key-value pair of body 
	

}
