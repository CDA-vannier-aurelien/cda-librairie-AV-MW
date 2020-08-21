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

    @Column(name = "est_validee")
    private boolean estValidee;

    @Column(name = "date_commande")
    private Date dateCommande = new Date();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
            @JoinColumn(name = "numero_commande")
    List<CommandeLine> commandeLine = new ArrayList<>();


}
