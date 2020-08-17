package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/** 
 * 
 * Classe enregistrant les informations des différents éditeurs.
 * 
 * @author PC
 *
 */
public class EditeurDto {

	
	/**
	 * Id de l'éditeur. Est unique et créé lors de son enregistrement en base de donnée.
	 */
	private int id;
	
	/**
	 * Nom de l'éditeur permettant de l'identifier.
	 */
	private String nom;

}
