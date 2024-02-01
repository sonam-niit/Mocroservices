package com.demo.mongo.controller;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mongo.model.MyBook;
import com.demo.mongo.service.MyBookService;

@RestController
@RequestMapping("/api/books")
public class MyBookController {

	@Autowired
	private MyBookService service;

	@PostMapping
	public ResponseEntity<MyBook> addBook(@RequestBody MyBook book) {
		MyBook createdBook = service.addBook(book);
		return ResponseEntity.created(URI.create("/api/books/" + createdBook.getId())).body(createdBook);
	}

	@GetMapping
	public ResponseEntity<List<MyBook>> getAllBooks() {
		return ResponseEntity.ok().body(service.getAllBooks());
	}

	@GetMapping("{id}")
	public ResponseEntity<MyBook> getBookById(@PathVariable String id) {

		return service.getBookById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		return service.getBookById(id).map(book -> {
			service.deleteBook(id);
			return ResponseEntity.ok().body("Book deleted successfully");
		}).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("{id}")
	public ResponseEntity<MyBook> updateUser(@RequestBody MyBook book, @PathVariable String id) {
		return service.getBookById(id).map(existingbook -> {
			return ResponseEntity.ok().body(service.updateUser(book, id));
		}).orElse(ResponseEntity.notFound().build());
	}

}