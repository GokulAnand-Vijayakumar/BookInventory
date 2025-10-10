package com.example.bookInventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookInventory.entity.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    // Add custom query methods if needed
}