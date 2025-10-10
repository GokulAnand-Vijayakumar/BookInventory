package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.State;
import com.example.bookInventory.repository.StateRepository;
import com.example.bookInventory.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public String addState(State state) {
        if (stateRepository.findByStateCode(state.getStateCode()).isPresent() ||
            stateRepository.findByStateName(state.getStateName()).isPresent()) {
            return "ADDFAILS";
        }
        stateRepository.save(state);
        return "POSTSUCCESS";
    }

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public State getStateById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    @Override
    public State updateStateName(Long id, String newName) {
        Optional<State> existing = stateRepository.findById(id);
        if (existing.isPresent()) {
            State state = existing.get();
            state.setStateName(newName);
            return stateRepository.save(state);
        }
        return null;
    }
}