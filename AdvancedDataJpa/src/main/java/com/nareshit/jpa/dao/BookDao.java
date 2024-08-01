package com.nareshit.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.jpa.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer>{


	public Iterable<Book>  findByBookName(String bookName);
	//select * from book inner join book_publiher iner join publisher...



	public Iterable<Book>  listBooksWithName(String bookName);
}
