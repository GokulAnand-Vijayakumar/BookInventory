package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.State;

public interface StateService {
    State save(State obj);
    State getById(Long id);
    List<State> getAll();
    void deleteById(Long id);
}
