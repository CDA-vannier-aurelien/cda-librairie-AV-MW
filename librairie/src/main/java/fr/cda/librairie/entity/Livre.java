package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livre {

    @Id
    private int reference;
    private int prix;
    private int quantitee;
    private String titre;
    @Column(name = "nombre_page")
    private String nbPage;

    @ManyToOne
    Auteur auteur;

    @ManyToOne
    Editeur editeur;

}
