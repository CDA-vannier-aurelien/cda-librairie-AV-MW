package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * Classe permettant de décupérer toutes es informations des différents utilisateurs à partir des
 * des différents servlet d'inscription et gestion utilisateur.
 * 
 * 
 * 
 * @author Fethi, Aurélien
 * @version 1.0
 *
 */
public class UtilisateurDto {

	/**
	 * Identifiant de  l'utilisateur. Est unique et non modifiable. Est généré automatiquement lors de l'inscription de l'entité en BDD.
	 */
    private int id;
    
    /**
     * String permettant de déterminer le nom de l'utilisateur. Est non unique modifiable et requis.
     * 
     */
    private String nom;
    
    /** 
     * String permettant de déterminer  le prénom de l'utilisateur. Est non unique, modifiable et requis.
     * 
     */
    private String prenom;
    
    /**
     * Date déterminant la date de naissance de l'utilisateur. Requis, modifiable.
     */
    private Date dateNaissance;
    
    /**
     * String premettant de récupérer  le login d'un utilisateur qui permettra de s'authentifier sur le site. Requis, modifiable, 
     */
  
    private String mail;
    private String password;
    private boolean isActivated;
    private Date dateConnection;
    private String nomRue;
    private int numeroPorte;
    private String complementAdresse;
    private String ville;
    private String codePostal;
    private String pays;
    private String labelRole;
}
