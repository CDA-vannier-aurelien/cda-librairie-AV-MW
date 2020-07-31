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
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
   private List<CommandeLine> listLivre = new ArrayList<>();

}
