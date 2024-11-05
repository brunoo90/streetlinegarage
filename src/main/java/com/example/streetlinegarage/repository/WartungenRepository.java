package com.example.streetlinegarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.streetlinegarage.model.Wartungen;

@Repository
public interface WartungenRepository extends JpaRepository<Wartungen, Long> {
}
