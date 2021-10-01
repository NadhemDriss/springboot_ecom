package com.example.users.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Document
public class Employer {
    @Id
    private String id;
    @NotNull(message = "name is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String nom;
    @NotNull(message = "prenom is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String prenom;
    @NotNull(message = "grade is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String grade;
    @NotNull(message = "cin is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String cin;
    @NotNull(message = "date embauche is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEmb;
    @NotNull(message = "salaire is required")
    private BigDecimal salaire;
    private int solde;

    public String getId() {
        return id;
    }

    public Employer() {
    }

    public Employer(String id, @NotNull(message = "name is required") String nom, @NotNull(message = "prenom is required") String prenom, @NotNull(message = "grade is required") String grade, @NotNull(message = "cin is required") String cin, @NotNull(message = "date embauche is required") Date dateEmb, @NotNull(message = "salaire is required") BigDecimal salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
        this.cin = cin;
        this.dateEmb = dateEmb;
        this.salaire = salaire;
        this.solde = 0;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDateEmb() {
        return dateEmb;
    }

    public void setDateEmb(Date dateEmb) {
        this.dateEmb = dateEmb;
    }

    public BigDecimal getSalaire() {
        return salaire;
    }

    public void setSalaire(BigDecimal salaire) {
        this.salaire = salaire;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
}
