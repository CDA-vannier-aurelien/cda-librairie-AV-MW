package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre {

    @Id
    private int reference;
    private double prix;
    private int quantitee;
    private String titre;
    private String description;
    @Column(name = "nombre_page")
    private int nbPage;

    @ManyToOne
    Auteur auteur;

    @ManyToOne
    Editeur editeur;

}
