package com.example.bookInventory.repository;

import com.example.bookInventory.entity.Inventory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByIsbn(String isbn); // This will return one Inventory record
}