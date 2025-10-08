package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.PurchaseLog;

public interface PurchaseLogService {
    PurchaseLog save(PurchaseLog obj);
    PurchaseLog getById(Long id);
    List<PurchaseLog> getAll();
    void deleteById(Long id);
}

