package fr.cda.librairie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ville {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom_ville")
	private String nom;
	@Column(name = "code_postal")
	private int codePostal;

	public Ville(String nomVille, int codePostal) {
		this.codePostal = codePostal;
		this.nom = nomVille;
	}
}
