package com.example.transportation.controller;

import com.example.transportation.entity.Transportation;
import com.example.transportation.service.TransportationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportations")
public class TransportationController {

    private final TransportationService service;

    public TransportationController(TransportationService service) {
        this.service = service;
    }

    // POST /transportations → Create a new record
    @PostMapping
    public ResponseEntity<Transportation> create(@RequestBody Transportation transportation) {
        Transportation saved = service.create(transportation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /transportations → Get all records
    @GetMapping
    public List<Transportation> getAll() {
        return service.getAll();
    }

    // GET /transportations/{id} → Get a record by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transportation> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /transportations/{id} → Delete a record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
