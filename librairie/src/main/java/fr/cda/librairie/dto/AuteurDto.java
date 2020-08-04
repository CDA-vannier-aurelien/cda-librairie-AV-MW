package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuteurDto {

	private String nom;
	private String prenom;
	private String nomUsuel;
	private int id;
}
