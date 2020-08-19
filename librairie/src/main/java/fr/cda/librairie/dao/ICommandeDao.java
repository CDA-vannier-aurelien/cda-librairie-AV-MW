package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface permetant l'ajout des commandes en base de donnée.
 * @author Fethi
 *
 */
@Repository
public interface ICommandeDao extends CrudRepository<Commande, Integer> {

}
