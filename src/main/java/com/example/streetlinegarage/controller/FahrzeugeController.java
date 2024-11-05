package com.example.streetlinegarage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.streetlinegarage.model.Fahrzeuge;
import com.example.streetlinegarage.repository.FahrzeugeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/fahrzeuge")
public class FahrzeugeController {

    @Autowired
    private FahrzeugeRepository fahrzeugeRepository;

    @GetMapping
    public List<Fahrzeuge> getAllFahrzeuge() {
        return fahrzeugeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Fahrzeuge> createFahrzeuge(@Valid @RequestBody Fahrzeuge fahrzeuge) {
        return ResponseEntity.ok(fahrzeugeRepository.save(fahrzeuge));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fahrzeuge> getFahrzeugeById(@PathVariable Long id) {
        return fahrzeugeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fahrzeuge> updateFahrzeuge(@PathVariable Long id, @Valid @RequestBody Fahrzeuge fahrzeugeDetails) {
        return fahrzeugeRepository.findById(id)
                .map(fahrzeuge -> {
                    fahrzeuge.setMarke(fahrzeugeDetails.getMarke());
                    fahrzeuge.setModell(fahrzeugeDetails.getModell());
                    fahrzeuge.setBaujahr(fahrzeugeDetails.getBaujahr());
                    fahrzeuge.setKilometerstand(fahrzeugeDetails.getKilometerstand());
                    return ResponseEntity.ok(fahrzeugeRepository.save(fahrzeuge));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFahrzeuge(@PathVariable Long id) {
        return fahrzeugeRepository.findById(id)
                .map(fahrzeuge -> {
                    fahrzeugeRepository.delete(fahrzeuge);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
