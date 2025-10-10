package com.example.bookInventory.service;

import com.example.bookInventory.entity.State;

import java.util.List;

public interface StateService {
    String addState(State state);
    List<State> getAllStates();
    State getStateById(Long id);
    State updateStateName(Long id, String newName);
}
