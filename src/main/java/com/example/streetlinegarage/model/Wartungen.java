package com.example.streetlinegarage.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Wartungen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wartung_id;
    private Long fahrzeug_id;
    private Long auftraggeber_id;
    @Temporal(TemporalType.DATE)
    private Date datum;
    private double kosten;
    private String zuständig_mechaniker;
    private String beschreibung;

    // Getters and Setters
    public Long getWartung_id() { return wartung_id; }
    public void setWartung_id(Long wartung_id) { this.wartung_id = wartung_id; }
    public Long getFahrzeug_id() { return fahrzeug_id; }
    public void setFahrzeug_id(Long fahrzeug_id) { this.fahrzeug_id = fahrzeug_id; }
    public Long getAuftraggeber_id() { return auftraggeber_id; }
    public void setAuftraggeber_id(Long auftraggeber_id) { this.auftraggeber_id = auftraggeber_id; }
    public Date getDatum() { return datum; }
    public void setDatum(Date datum) { this.datum = datum; }
    public double getKosten() { return kosten; }
    public void setKosten(double kosten) { this.kosten = kosten; }
    public String getZustaendig_mechaniker() { return zuständig_mechaniker; }
    public void setZustaendig_mechaniker(String zuständig_mechaniker) { this.zuständig_mechaniker = zuständig_mechaniker; }
    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }
}
