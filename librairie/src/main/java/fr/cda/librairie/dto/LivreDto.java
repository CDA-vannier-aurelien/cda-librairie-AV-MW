package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivreDto {
	private int reference;
	private int prix;
	private int quantitee;
	private String titre;
	private String nbPage;
	private String auteur;
	private String editeur;
}
