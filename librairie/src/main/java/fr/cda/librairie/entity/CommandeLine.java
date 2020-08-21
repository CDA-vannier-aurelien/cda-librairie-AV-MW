package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints={
		
        @UniqueConstraint(columnNames = {"numero_commande", "reference"}
        )})

public class CommandeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLigne;

    @ManyToOne
            @JoinColumn(name = "numero_commande")
    Commande commande;

    @ManyToOne
            @JoinColumn(name = "reference")
    Livre livre;

  	@Column(name= "quantite_commandee")
    private int quantiteCommandee;
    
}
