package com.example.bookInventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookInventory.entity.BookAuthor;
import com.example.bookInventory.entity.BookAuthorId;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

	void deleteById(BookAuthorId id);
    // Add custom query methods if needed
}