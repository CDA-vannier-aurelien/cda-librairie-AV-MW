package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
/**
 * Interface permettant l'enregistrement des différentes villes d'habitation des utilisateurs.
 * @author PC
 *
 */
public interface IVilleDao extends CrudRepository<Ville, Integer> {
    Optional<Ville>findByNom(String nomVille);

}
