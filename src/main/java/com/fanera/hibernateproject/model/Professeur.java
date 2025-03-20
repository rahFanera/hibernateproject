package com.fanera.hibernateproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeurs")
public class Professeur {
    @Id
    @Column(length = 20)
    private String codeprof;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50)
    private String grade;

    public Professeur() {}

    public Professeur(String nom, String prenom, String grade) {
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    public Professeur(String codeprof, String nom, String prenom, String grade) {
        this.codeprof = codeprof;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    public String getCodeprof() {
        return codeprof;
    }

    public void setCodeprof(String codeprof) {
        this.codeprof = codeprof;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Professeur [codeprof=" + codeprof + ", nom=" + nom + ", prenom="
                + prenom + ", grade=" + grade + "]";
    }
}
