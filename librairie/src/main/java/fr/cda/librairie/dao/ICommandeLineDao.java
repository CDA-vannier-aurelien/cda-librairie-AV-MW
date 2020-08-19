package fr.cda.librairie.dao;

import fr.cda.librairie.entity.CommandeLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Inteface permettant l'enregistrement des informations de chaque ligne d 'une commande en base de donnée.
 * @author PC
 *
 */
@Repository
public interface ICommandeLineDao extends CrudRepository<CommandeLine, Integer> {
}
