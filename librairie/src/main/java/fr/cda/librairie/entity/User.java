package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
=======

>>>>>>> Dev
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Utilisateur",
		uniqueConstraints = {
		@UniqueConstraint(columnNames = "login")} )

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String prenom;

    private String login;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Pays pays;
    
    private String nomRue;
    
    private int numeroPorte;
    
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Ville ville;
    
    private String complementAdresse;
    
    private String password;
    
    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "date_last_connection")
	private Date dateConnection;

    @Column(name = "date_naissance")
<<<<<<< HEAD
    private LocalDateTime dateNaissance;

    @ManyToOne(cascade = CascadeType.REFRESH)
    Adresse adresse;

=======
    private Date dateNaissance;
    
>>>>>>> Dev
    @OneToMany(cascade = CascadeType.PERSIST)
    List<Commande> commandes = new ArrayList<>();

    @ManyToOne
	Role role;
    
    

    public User(String pNom, String pPrenom) {
        this.nom = pNom;
        this.prenom = pPrenom;
    }

}
