package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.Publisher;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.respository.PublisherRepository;
import com.example.bookInventory.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getById(Long publisherId) {
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found with ID: " + publisherId));
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> getByName(String name) {
        return publisherRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Publisher> getByCity(String city) {
        return publisherRepository.findByCityIgnoreCase(city);
    }

    @Override
    public List<Publisher> getByState(String stateCode) {
        return publisherRepository.findByStateCodeIgnoreCase(stateCode);
    }

    @Override
    public Publisher updateName(Long publisherId, String name) {
        Publisher publisher = getById(publisherId);
        publisher.setName(name);
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updateCity(Long publisherId, String city) {
        Publisher publisher = getById(publisherId);
        publisher.setCity(city);
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher updateState(Long publisherId, String stateCode) {
        Publisher publisher = getById(publisherId);
        publisher.setStateCode(stateCode);
        return publisherRepository.save(publisher);
    }
}