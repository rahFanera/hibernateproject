package com.fanera.hibernateproject.model;

import jakarta.persistence.*;

@Entity
@Table(name ="salles")
public class Salle {

    @Id
    private String codesalle;

    @Column(name = "designation", length = 10)
    private String designation;

    public Salle() {}

    public Salle(String codesalle, String designation) {
        this.codesalle = codesalle;
        this.designation = designation;
    }

    public Salle(String designation) {
        this.designation = designation;
    }

    public String getCodesalle() {
        return codesalle;
    }

    public void setCodesalle(String codesalle) {
        this.codesalle = codesalle;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Salle [codesalle=" + codesalle + ", designation=" + designation + "]";
    }
}
