package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICommandeDao extends CrudRepository<Commande, Integer> {

}
