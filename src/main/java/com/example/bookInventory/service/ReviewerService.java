package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Reviewer;

public interface ReviewerService {
    Reviewer save(Reviewer obj);
    Reviewer getById(Long id);
    List<Reviewer> getAll();
    void deleteById(Long id);
}
