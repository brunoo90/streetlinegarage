package com.example.streetlinegarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.streetlinegarage.model.Fahrzeuge;

@Repository
public interface FahrzeugeRepository extends JpaRepository<Fahrzeuge, Long> {
}
