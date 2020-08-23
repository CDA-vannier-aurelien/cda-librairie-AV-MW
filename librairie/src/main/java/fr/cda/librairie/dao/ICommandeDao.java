package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface permetant l'ajout des commandes en base de donnée.
 *
 * @author Fethi
 */
@Repository
public interface ICommandeDao extends CrudRepository<Commande, Integer> {
    @Override
    Optional<Commande> findById(Integer integer);

}
