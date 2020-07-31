package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommandeDao extends CrudRepository<Commande, Integer> {

}
