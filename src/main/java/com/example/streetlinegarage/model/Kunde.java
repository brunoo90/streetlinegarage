package com.example.streetlinegarage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kunde_id;
    private String name;
    private String adresse;
    private String telefonnummer;

    // Getters and Setters
    public Long getKunde_id() { return kunde_id; }
    public void setKunde_id(Long kunde_id) { this.kunde_id = kunde_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getTelefonnummer() { return telefonnummer; }
    public void setTelefonnummer(String telefonnummer) { this.telefonnummer = telefonnummer; }
}
