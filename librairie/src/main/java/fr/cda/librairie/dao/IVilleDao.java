package fr.cda.librairie.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Ville;

@Repository
/**
 * Interface permettant l'enregistrement des différentes villes d'habitation des
 * utilisateurs.
 * 
 * @author PC
 *
 */
public interface IVilleDao extends CrudRepository<Ville, Integer> {
	Optional<Ville> findByNomAndCodePostal(String nomVille, int codePostal);

	Optional<Ville> findByNom(String nomVille);
}
