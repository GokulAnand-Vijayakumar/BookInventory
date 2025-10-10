package com.example.bookInventory.repository;

import com.example.bookInventory.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long> {
    Optional<State> findByStateCode(String stateCode);
    Optional<State> findByStateName(String stateName);
}