package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * 
 * Classe permettant de recueillir les différentes informations provenant des servlet concernant les livres.
 * @author PC
 *
 */
public class LivreDto {
	private int reference;
	private int prix;
	private int quantitee;
	private String titre;
	private String nbPage;
	private String auteur;
	private String editeur;
}
