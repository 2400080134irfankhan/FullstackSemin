package com.example.transportation.service;

import com.example.transportation.entity.Transportation;
import com.example.transportation.repository.TransportationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportationService {

    private final TransportationRepository repository;

    // Constructor injection (recommended approach)
    public TransportationService(TransportationRepository repository) {
        this.repository = repository;
    }

    // Create a new transportation record
    public Transportation create(Transportation transportation) {
        return repository.save(transportation);
    }

    // Get all transportation records
    public List<Transportation> getAll() {
        return repository.findAll();
    }

    // Get a transportation record by ID
    public Optional<Transportation> getById(Long id) {
        return repository.findById(id);
    }

    // Delete a transportation record by ID
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
