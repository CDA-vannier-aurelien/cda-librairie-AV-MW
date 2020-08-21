package fr.cda.librairie.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Utilisateur",
		uniqueConstraints = {
		@UniqueConstraint(columnNames = "mail")} )

public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	private String prenom;

    private String mail;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Pays pays;
    
    private String nomRue;
    
    private int numeroPorte;
    
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Ville ville;
    
    private String complementAdresse;
    
    private String password;
    
    @Column(name = "is_activated")
    private boolean estActive;

	@Column(name = "date_last_connection")
	private Date dateConnection;

    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Commande> commandes = new ArrayList<>();

    @ManyToOne
	Role role;
    
    

	public User(String pNom, String pPrenom) {
		this.nom = pNom;
		this.prenom = pPrenom;
	}

}
