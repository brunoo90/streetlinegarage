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

import com.example.streetlinegarage.model.Wartungen;
import com.example.streetlinegarage.repository.WartungenRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/wartungen")
public class WartungenController {

    @Autowired
    private WartungenRepository wartungenRepository;

    @GetMapping
    public List<Wartungen> getAllWartungen() {
        return wartungenRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Wartungen> createWartungen(@Valid @RequestBody Wartungen wartung) {
        return ResponseEntity.ok(wartungenRepository.save(wartung));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wartungen> getWartungenById(@PathVariable Long id) {
        return wartungenRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wartungen> updateWartungen(@PathVariable Long id, @Valid @RequestBody Wartungen wartungDetails) {
        return wartungenRepository.findById(id)
                .map(wartung -> {
                    wartung.setFahrzeug_id(wartungDetails.getFahrzeug_id());
                    wartung.setAuftraggeber_id(wartungDetails.getAuftraggeber_id());
                    wartung.setDatum(wartungDetails.getDatum());
                    wartung.setKosten(wartungDetails.getKosten());
                    wartung.setZustaendig_mechaniker(wartungDetails.getZustaendig_mechaniker());
                    wartung.setBeschreibung(wartungDetails.getBeschreibung());
                    return ResponseEntity.ok(wartungenRepository.save(wartung));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWartungen(@PathVariable Long id) {
        return wartungenRepository.findById(id)
                .map(wartung -> {
                    wartungenRepository.delete(wartung);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
