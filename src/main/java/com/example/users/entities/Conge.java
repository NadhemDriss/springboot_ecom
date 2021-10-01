package com.example.users.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
public class Conge {
    @Id
    private String id;
    private Integer nbrJour;
    @NotNull(message = "date sortie is required")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateSortie;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @NotNull(message = "date retour is required")
    private Date dateRetour;
    @NotNull(message = "Etat is required")
    private Etat etat;

    public Conge() {
    }

    public Conge(Integer nbrJour, @NotNull(message = "date sortie is required") Date dateSortie, @NotNull(message = "date retour is required") Date dateRetour, @NotNull(message = "Etat is required") Etat etat) {
        this.nbrJour = nbrJour;
        this.dateSortie = dateSortie;
        this.dateRetour = dateRetour;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNbrJour() {
        return nbrJour;
    }

    public void setNbrJour(Integer nbrJour) {
        this.nbrJour = nbrJour;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
