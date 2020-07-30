package fr.cda.librairie.dto;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import fr.cda.librairie.entity.User;
import fr.cda.librairie.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component

/**
 * 
 * UserDto est la classe enregistrant les infromations reçues dans les
 * contrôleurs. Ces informations seront transmises aux services afin d'appeler
 * les méthodes nécessaires à la gestion des entités User.
 * 
 * @author PC
 *
 */

public class UserDto {

	public UserDto(String login2, String passwordHash, String prenom2, String nom2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	private int IdUser;

	/**
	 * Le login est le surnom que le client choisit lors de l'inscription est
	 * correspondra à son ID. Est unique, non modifiable et requis.
	 * 
	 * @see User#getLogin()
	 * @see UserServiceImpl#checkSiExisteBDD(String)
	 * @see UserServiceImpl#selectByLogin(String)
	 * @see UserDao#selectByLogin(String)
	 * 
	 */
	private String login;

	/**
	 * Le password est le mot de passe obligatoire du user pour se connecter à son
	 * compte. Le code est hashé afin de le sécuriser notamment en BDD. Non
	 * modifiable, non unique et requis.
	 * 
	 * @see User#getPassword()
	 * 
	 */
	private String password;

	/**
	 * Le prénom est un élément d'identification du userDto. Modifiable, requis et
	 * non unique.
	 * 
	 * @see User#getPrenom()
	 * @see User#setPrenom(String)
	 */
	private String prenom;

	/**
	 * Le nom est un élément d'identification du user. Modifiable, requis et non
	 * unique.
	 * 
	 * @see Usert#getNom()
	 * @see User#setNom(String)
	 */
	private String nom;
}
