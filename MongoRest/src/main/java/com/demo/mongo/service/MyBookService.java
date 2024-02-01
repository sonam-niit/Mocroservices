package com.demo.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mongo.model.MyBook;
import com.demo.mongo.repo.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository repo;

	public MyBook addBook(MyBook book) {
		return repo.save(book);
	}

	public List<MyBook> getAllBooks() {
		return repo.findAll();
	}

	public Optional<MyBook> getBookById(String id) {
		return repo.findById(id);
	}

	public void deleteBook(String id) {
		repo.deleteById(id);
	}

	public MyBook updateUser(MyBook book, String id) {
		MyBook existingBook = repo.findById(id).get();
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setYear(book.getYear());
		existingBook = repo.save(existingBook);
		return existingBook;
	}

}