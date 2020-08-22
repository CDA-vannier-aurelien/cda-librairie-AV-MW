package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Livre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface permettant d'enregistrer les informations des livres en base de
 * donnée.
 *
 * @author PC
 */
@Repository
public interface ILivreDao extends PagingAndSortingRepository<Livre, Integer> {

    public List<Livre> findAll();

    @Query("SELECT coalesce(max(ch.id), 0) FROM Auteur ch")
    public Long getMaxId();
}
