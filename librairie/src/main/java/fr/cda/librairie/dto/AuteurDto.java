package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe permettant d'enregistrer les différentes informations recueillies pour
 * les auteurs.
 * 
 * * @see AuteurServiceImpl#addAuteur(AuteurDto)
 * 
 * @author PC
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuteurDto {

	/**
	 * Nom réel de l'auteur saisi à l'enregistrement
	 */
	private String nom;

	/**
	 * Prenom réel de l'auteur saisi à l'enregistrement.
	 */
	private String prenom;

	/**
	 * Nom utilisé dans les informations du programme de manière à l'identifier en
	 * cas de doublon nom plus prénom.
	 */
	private String nomUsage;

	/**
	 * Id de l'auteutr. Est unique et crée à l'implémentation de l'auteur en base de
	 * donnée la première fois.
	 */
	private int id;
}
