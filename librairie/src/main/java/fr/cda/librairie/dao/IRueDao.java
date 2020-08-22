package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Rue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 *
 * interface permettant l'enregistrement des différentes rues où habitent les utilisateurs.
 * @author PC
 *
 */
public interface IRueDao extends CrudRepository<Rue, Integer> {
    Optional<Rue> findByNom(String nomRue);
}
