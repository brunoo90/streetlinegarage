package com.example.streetlinegarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.streetlinegarage.model.Kunde;

@Repository
public interface KundeRepository extends JpaRepository<Kunde, Long> {
    boolean existsByTelefonnummer(String telefonnummer);
}
