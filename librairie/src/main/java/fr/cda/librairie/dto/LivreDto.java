package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * 
 * Classe permettant de recueillir les différentes informations provenant des
 * servlet concernant les livres.
 * 
 * @author Matthieu
 * @version 1.0
 */
public class LivreDto {

	/**
	 * int permettant de définir l'id d'un livre. Est requis, non modifiable et
	 * unique. est créé lors de l'ajout en base de donnée.
	 */
	private int reference;

	/**
	 * int permettant d'enregistrer le prix d'un livre à partir des différents
	 * controleurs. Est requis, modifiable, non nul, non unique.
	 */
	private double prix;

	/**
	 * int permettant de déterminer le nombre d'exemplaires d'un même livre de
	 * disponible.
	 */
	private int quantitee;
	private String titre;
	private int nbPage;
	private String auteur;
	private String editeur;
}
