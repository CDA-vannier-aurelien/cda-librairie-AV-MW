package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Interface permetant l'ajout des commandes en base de donnée.
 *
 * @author Fethi
 */
@Repository
public interface ICommandeDao extends CrudRepository<Commande, Integer> {

    Optional<Commande> findById(Integer integer);

    @Query


    @Transactional
    void removeByNumeroCommande(int id);


}
