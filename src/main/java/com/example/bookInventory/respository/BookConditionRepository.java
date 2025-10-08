package com.example.bookInventory.respository;

import com.example.bookInventory.entity.BookCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookConditionRepository extends JpaRepository<BookCondition, Long> {
    // You can add custom query methods here if needed
}