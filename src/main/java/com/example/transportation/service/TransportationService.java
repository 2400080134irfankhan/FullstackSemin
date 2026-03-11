package com.example.transportation.service;

import com.example.transportation.entity.Transportation;
import com.example.transportation.repository.TransportationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportationService {

    private final TransportationRepository repository;

    public TransportationService(TransportationRepository repository) {
        this.repository = repository;
    }

    public Transportation create(Transportation transportation) {
        return repository.save(transportation);
    }

    public List<Transportation> getAll() {
        return repository.findAll();
    }

    public Optional<Transportation> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Transportation> update(Long id, Transportation updated) {
        return repository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setType(updated.getType());
            existing.setOrigin(updated.getOrigin());
            existing.setDestination(updated.getDestination());
            existing.setStatus(updated.getStatus());
            existing.setCapacity(updated.getCapacity());
            existing.setPrice(updated.getPrice());
            existing.setDate(updated.getDate());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
