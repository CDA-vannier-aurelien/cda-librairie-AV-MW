package fr.cda.librairie.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.cda.librairie.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Utilisateur")

/**
 * Classe permettant la création de l'entité User qui sera appelée entre
 * l'UserDao et l'UserService
 * 
 * @see UserServiceImpl#save(User)
 * @see UserServiceImpl#deleteClient(User)
 * @see UserDao#ajoutClientBdd(Client)
 * @see ClientDaoImpl#deleteClientBdd(Client)
 * @author Aurélien
 * @Version 1.0
 *
 */
public class User {

	/**
	 * Le login est le surnom que le user choisit lors de l'inscription. Est unique,
	 * modifiable et requis.
	 * 
	 * @see User#getLogin()
	 * @see UserServiceImpl#checkSiExisteBDD(String)
	 * @see UserServiceImpl#selectByLogin(String)
	 * @see UsertDao#selectByLogin(String)
	 * 
	 * @see ChienDaoImpl#getListChienByClient(String)
	 */
	@Id
	private int Id;

	private String nom;

	private String prenom;

	@Column(name = "date_naissance")
	private Date dateNaissance;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "login", referencedColumnName = "login", nullable = false)
	private CompteUser adresse;

	public User(String pNom, String pPrenom) {
		this.nom = pNom;
		this.prenom = pPrenom;
	}

}
