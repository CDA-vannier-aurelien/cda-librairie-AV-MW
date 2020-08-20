package fr.cda.librairie.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDto {

	
	private int numeroCommande;
	private Date dateCommande = new Date();
	private int nombreArticles;
	private int quantite;

}
