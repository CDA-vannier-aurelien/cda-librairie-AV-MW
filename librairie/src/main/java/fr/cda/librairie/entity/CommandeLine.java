package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"numero_commande", "reference"}
        )})
public class CommandeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
            @JoinColumn(name = "numero_commande")
    Commande commande;

    @ManyToOne
            @JoinColumn(name = "reference")
    Livre livre;

    private int quantite;
}
