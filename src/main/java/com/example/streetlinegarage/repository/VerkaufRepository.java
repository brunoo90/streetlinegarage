package com.example.streetlinegarage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.streetlinegarage.model.Verkauf;

@Repository
public interface VerkaufRepository extends JpaRepository<Verkauf, Long> {
}
