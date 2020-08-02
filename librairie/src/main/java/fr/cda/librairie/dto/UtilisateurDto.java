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
public class UtilisateurDto {

    private int id;
    private  int codePostal;
    private String nom;
    private String prenom;
    private LocalDateTime dateNaissance;
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
