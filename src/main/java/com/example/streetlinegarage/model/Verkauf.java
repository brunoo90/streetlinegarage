package com.example.streetlinegarage.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Verkauf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verkauf_id;
    
    private Long fahrzeug_id;
    private Long verkäufer_id;
    private Long käufer_id;

    @Temporal(TemporalType.DATE)
    private Date verkaufsdatum;
    
    private double verkaufspreis;

    // Getters and Setters
    public Long getVerkauf_id() { 
        return verkauf_id; 
    }
    
    public void setVerkauf_id(Long verkauf_id) { 
        this.verkauf_id = verkauf_id; 
    }
    
    public Long getFahrzeug_id() { 
        return fahrzeug_id; 
    }
    
    public void setFahrzeug_id(Long fahrzeug_id) { 
        this.fahrzeug_id = fahrzeug_id; 
    }
    
    public Long getVerkäufer_id() { 
        return verkäufer_id; 
    }
    
    public void setVerkäufer_id(Long verkäufer_id) { 
        this.verkäufer_id = verkäufer_id; 
    }
    
    public Long getKäufer_id() { 
        return käufer_id; 
    }
    
    public void setKäufer_id(Long käufer_id) { 
        this.käufer_id = käufer_id; 
    }
    
    public Date getVerkaufsdatum() { 
        return verkaufsdatum; 
    }
    
    public void setVerkaufsdatum(Date verkaufsdatum) { 
        this.verkaufsdatum = verkaufsdatum; 
    }
    
    public double getVerkaufspreis() { 
        return verkaufspreis; 
    }
    
    public void setVerkaufspreis(double verkaufspreis) { 
        this.verkaufspreis = verkaufspreis; 
    }
}
