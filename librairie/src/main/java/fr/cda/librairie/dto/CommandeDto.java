package fr.cda.librairie.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
