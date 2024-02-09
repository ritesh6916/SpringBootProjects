package com.ritesh.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// To Add new Book
	@PostMapping(path = "/book")
	public Book addBook(@ModelAttribute("book") Book tempBook) {

		book = tempBook;
		repository.save(book);
		logger.debug("added new book named: " + tempBook.getName());
		return book;
	} // while colling provide data in Key-value pair of body

	// To get Book by ID
	@GetMapping(path = "/book/{id}")
	public Book getBookById(@PathVariable("id") int id) {

		Optional<Book> optional = null;
		try {
			optional = repository.findById(id);
			book = optional.get();
			return book;
		} catch (Exception e) {
			logger.warn("No book is available with id: " + id);
			return null;
		}
	}
	
	// To get all books 
	@GetMapping(path = "/book")
	public List<Book> getAllBooks() {
		
		List<Book> list = new ArrayList<Book>();
		Iterable<Book> all = repository.findAll();
		for (Book book : all) {
			list.add(book);
		}
		return list;
	}
	
	// To Update price by ID
	@PutMapping("/book")
	public Book updateBookByID(@RequestBody Book tempBook) {
		
		book = getBookById(tempBook.getId());
		return book;
	}
	
	//To Delete a book by ID
	@DeleteMapping("/book/{id}")
	public boolean deleteBookById(@RequestParam("id") int id ) {
		repository.deleteById(id);
		return false;
	}
	
	//To Delete all books 
		@DeleteMapping("/book/{id}")
		public boolean deleteAllBooks() {
			repository.deleteAll();
			return false;
		}
	
}