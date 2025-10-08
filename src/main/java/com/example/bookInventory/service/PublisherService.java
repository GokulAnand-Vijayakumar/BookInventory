package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Publisher;

public interface PublisherService {
    Publisher save(Publisher obj);
    Publisher getById(Long id);
    List<Publisher> getAll();
    void deleteById(Long id);
}