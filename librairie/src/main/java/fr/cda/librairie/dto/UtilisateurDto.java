package fr.cda.librairie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilisateurDto {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String login;
    private String password;
    private boolean isActivated;
    private Date dateConnection;
    private String nomRue;
    private int numeroPorte;
    private String nomVille;
    private String nomPays;
    private String labelRole;
}
