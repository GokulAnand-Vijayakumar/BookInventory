package com.example.bookInventory.service;


import java.math.BigDecimal;
import java.util.List;

import com.example.bookInventory.controller.BookConditionController;

public interface BookConditionService {

    // Create a new BookCondition
    BookConditionController save(BookConditionController obj);

    // Get BookCondition by ID
    BookConditionService getById(Long ranks);

    // Get all BookConditions
    List<BookConditionController> getAll();

    // Delete BookCondition by ID
    void deleteById(Long ranks);

    // Update price by ranks
    BookConditionController updatePrice(Long ranks, BigDecimal price);

    // Update description by ranks
    BookConditionService updateDescription(Long ranks, String description);

    // Update full description by ranks
    BookConditionService updateFullDescription(Long ranks, String fullDescription);
}