package com.ritesh.boot.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ritesh.boot.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}