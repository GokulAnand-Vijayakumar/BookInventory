package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/post")
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
        Publisher saved = publisherService.save(publisher);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long publisherId) {
        Publisher publisher = publisherService.getById(publisherId);
        return ResponseEntity.ok(publisher);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Publisher>> getPublisherByName(@PathVariable String name) {
        return ResponseEntity.ok(publisherService.getByName(name));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Publisher>> getPublishersByCity(@PathVariable String city) {
        return ResponseEntity.ok(publisherService.getByCity(city));
    }

    @GetMapping("/state/{stateCode}")
    public ResponseEntity<List<Publisher>> getPublishersByState(@PathVariable String stateCode) {
        return ResponseEntity.ok(publisherService.getByState(stateCode));
    }

    @PutMapping("/update/name/{publisherId}")
    public ResponseEntity<Publisher> updatePublisherName(@PathVariable Long publisherId, @RequestBody String name) {
        return ResponseEntity.ok(publisherService.updateName(publisherId, name));
    }

    @PutMapping("/update/city/{publisherId}")
    public ResponseEntity<Publisher> updatePublisherCity(@PathVariable Long publisherId, @RequestBody String city) {
        return ResponseEntity.ok(publisherService.updateCity(publisherId, city));
    }

    @PutMapping("/update/state/{publisherId}")
    public ResponseEntity<Publisher> updatePublisherState(@PathVariable Long publisherId, @RequestBody String stateCode) {
        return ResponseEntity.ok(publisherService.updateState(publisherId, stateCode));
    }

    @GetMapping()
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return ResponseEntity.ok(publisherService.getAll());
    }
}