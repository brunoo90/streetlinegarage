package com.example.streetlinegarage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fahrzeuge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fahrzeug_id;
    private Long kunde_id;
    private String marke;
    private String modell;
    private int baujahr;
    private int kilometerstand;

    // Getters and Setters
    public Long getFahrzeug_id() { return fahrzeug_id; }
    public void setFahrzeug_id(Long fahrzeug_id) { this.fahrzeug_id = fahrzeug_id; }
    public Long getKunde_id() { return kunde_id; }
    public void setKunde_id(Long kunde_id) { this.kunde_id = kunde_id; }
    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public int getBaujahr() { return baujahr; }
    public void setBaujahr(int baujahr) { this.baujahr = baujahr; }
    public int getKilometerstand() { return kilometerstand; }
    public void setKilometerstand(int kilometerstand) { this.kilometerstand = kilometerstand; }
}
