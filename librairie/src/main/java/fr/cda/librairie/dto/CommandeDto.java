package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeDto {


    private int numeroCommande;
    private Date dateCommande;
    private int nombreArticles;
    private int prixTotal;
    private int etatCommande;

}
