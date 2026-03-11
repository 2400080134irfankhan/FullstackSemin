package com.example.transportation.controller;

import com.example.transportation.entity.Transportation;
import com.example.transportation.service.TransportationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportations")
@CrossOrigin(origins = "*")
public class TransportationController {

    private final TransportationService service;

    public TransportationController(TransportationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transportation> create(@RequestBody Transportation transportation) {
        Transportation saved = service.create(transportation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Transportation> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transportation> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transportation> update(@PathVariable Long id,
                                                  @RequestBody Transportation transportation) {
        return service.update(id, transportation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
