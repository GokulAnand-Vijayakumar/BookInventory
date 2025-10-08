package com.example.bookInventory.service;


import java.util.List;

import com.example.bookInventory.entity.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart save(ShoppingCart obj);
    ShoppingCart getById(Long id);
    List<ShoppingCart> getAll();
    void deleteById(Long id);
}

