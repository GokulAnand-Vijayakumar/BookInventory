package com.example.bookInventory.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2, nullable = false, unique = true)
    private String stateCode;

    @Column(length = 50, nullable = false, unique = true)
    private String stateName;

    public State() {}

    public State(Long id, String stateCode, String stateName) {
        this.id = id;
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public Long getId() {
        return id;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State [id=" + id + ", stateCode=" + stateCode + ", stateName=" + stateName + "]";
    }
}