package fr.cda.librairie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String password;
    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "date_last_connection")
	private Date dateConnection;

    @Column(name = "date_naissance")
    private LocalDateTime dateNaissance;

    @ManyToOne(cascade = CascadeType.REFRESH)
    Adresse adresse;

    @OneToMany(cascade = CascadeType.PERSIST)
    List<Commande> commandes = new ArrayList<>();

    @ManyToOne
	Role role;

    public User(String pNom, String pPrenom) {
        this.nom = pNom;
        this.prenom = pPrenom;
    }

}
