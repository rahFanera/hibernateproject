package com.fanera.hibernateproject.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "occuper")
public class Occuper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeoccuper;

    @ManyToOne
    @JoinColumn(name = "codeprof", referencedColumnName = "codeprof", nullable = false)
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "codesalle", referencedColumnName = "codesalle", nullable = false)
    private Salle salle;

    @Temporal(TemporalType.DATE)
    private Date date;

    public int getCodeoccuper() {
        return codeoccuper;
    }

    public void setCodeoccuper(int codeoccuper) {
        this.codeoccuper = codeoccuper;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
