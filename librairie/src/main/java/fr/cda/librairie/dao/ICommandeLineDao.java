package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.CommandeLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Inteface permettant l'enregistrement des informations de chaque ligne d 'une commande en base de donnée.
 *
 * @author PC
 */
@Repository
public interface ICommandeLineDao extends CrudRepository<CommandeLine, Integer> {

    List<CommandeLine>findCommandeLineByCommande_NumeroCommande(int numero);


}
