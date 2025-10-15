package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.BookAuthor;

public interface BookAuthorService {
	void assignAuthorToBook(String isbn, Integer authorId, String primaryAuthorFlag);
	void removeAuthorFromBook(String isbn, Integer authorId);
	List<BookAuthor> getAllBookAuthor();
	void assignAuthorToBook(String isbn, Long authorId, String primaryAuthorFlag);
	void removeAuthorFromBook(String isbn, Long authorId);
}