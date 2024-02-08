package com.ritesh.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity   // in case of different table name and class name
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // for auto increment  
	private int id;

	@Column(name = "book_name")   // provide if field name & column name is different
	private String name;
	
	private String publication;   // @Column not required if field and column name is same

	private String author;

	@Column(name = "book_price")
	private double price;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String publication, String author, double price) {
		super();
		this.id = id;
		this.name = name;
		this.publication = publication;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publication=" + publication + ", author=" + author + ", price="
				+ price + "]";
	}

}
