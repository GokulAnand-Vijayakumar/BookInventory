package com.example.bookInventory.service;


import java.util.List;

import com.example.bookInventory.entity.Inventory;

public interface InventoryService {
    Inventory save(Inventory obj);
    Inventory getById(Long id);
    List<Inventory> getAll();
    void deleteById(Long id);
}