package com.example.bookInventory.controller;

import com.example.bookInventory.entity.State;
import com.example.bookInventory.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateService stateService;

    // POST: Add new state
    @PostMapping("/post")
    public ResponseEntity<?> addState(@RequestBody State state) {
        String result = stateService.addState(state);
        if ("POSTSUCCESS".equals(result)) {
            return ResponseEntity.ok(new ApiResponse("POSTSUCCESS", "State added successfully"));
        } else {
            return ResponseEntity.badRequest().body(new ApiResponse("ADDFAILS", "State already exists"));
        }
    }

    // GET: Get all states
    @GetMapping("/states")
    public ResponseEntity<List<State>> getAllStates() {
        return ResponseEntity.ok(stateService.getAllStates());
    }

    // GET: Get state by ID
    @GetMapping("/update/name/{stateId}")
    public ResponseEntity<?> getStateById(@PathVariable Long stateId) {
        State state = stateService.getStateById(stateId);
        if (state != null) {
            return ResponseEntity.ok(state);
        } else {
            return ResponseEntity.status(404).body("State not found");
        }
    }

    // PUT: Update state name by ID
    @PutMapping("/{stateId}")
    public ResponseEntity<?> updateStateName(@PathVariable Long stateId, @RequestBody State updatedState) {
        State state = stateService.updateStateName(stateId, updatedState.getStateName());
        if (state != null) {
            return ResponseEntity.ok("State updated successfully");
        } else {
            return ResponseEntity.status(404).body("State not found");
        }
    }

    // Response wrapper
    static class ApiResponse {
        private String code;
        private String message;

        public ApiResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}