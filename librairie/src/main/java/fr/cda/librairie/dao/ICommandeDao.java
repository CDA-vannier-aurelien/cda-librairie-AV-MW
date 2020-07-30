package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import org.springframework.data.repository.CrudRepository;

public interface ICommandeDao extends CrudRepository<Commande, Integer> {
}
