package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.cda.librairie.entity.Livre;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroCommande;
    private Date dateCommande;
   private List<Livre> listLivre = new ArrayList<>();
}
