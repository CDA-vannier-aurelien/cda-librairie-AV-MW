package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_commande")
    private int numeroCommande;

    @Column(name = "date_commande")
    private Date dateCommande = new Date();
    
    @Column(name = "nombre_articles")
    private int nombreArticles;
    
    @Column(name = "prix_total")
    private double prixTotal;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    List<CommandeLine> commandeLine = new ArrayList<>();
    

}
