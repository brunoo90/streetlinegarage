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

import com.example.streetlinegarage.model.Kunde;
import com.example.streetlinegarage.repository.KundeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/kunden")
public class KundeController {

    @Autowired
    private KundeRepository kundeRepository;

    @GetMapping
    public List<Kunde> getAllKunden() {
        return kundeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Kunde> createKunde(@Valid @RequestBody Kunde kunde) {
        if (kundeRepository.existsByTelefonnummer(kunde.getTelefonnummer())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(kundeRepository.save(kunde));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kunde> getKundeById(@PathVariable Long id) {
        return kundeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kunde> updateKunde(@PathVariable Long id, @Valid @RequestBody Kunde kundeDetails) {
        return kundeRepository.findById(id)
                .map(kunde -> {
                    kunde.setName(kundeDetails.getName());
                    kunde.setAdresse(kundeDetails.getAdresse());
                    kunde.setTelefonnummer(kundeDetails.getTelefonnummer());
                    return ResponseEntity.ok(kundeRepository.save(kunde));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKunde(@PathVariable Long id) {
        return kundeRepository.findById(id)
                .map(kunde -> {
                    kundeRepository.delete(kunde);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
