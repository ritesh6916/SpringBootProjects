package com.ritesh.boot.persistence;

import org.springframework.data.repository.CrudRepository;

import com.ritesh.boot.entity.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {

}