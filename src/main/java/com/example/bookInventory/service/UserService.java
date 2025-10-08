package com.example.bookInventory.service;


import java.util.List;

import com.example.bookInventory.entity.User;

public interface UserService {
    User save(User obj);
    User getById(Long id);
    List<User> getAll();
    void deleteById(Long id);
}

