package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Pays;
import fr.cda.librairie.entity.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IPaysDao extends CrudRepository<Pays, Integer> {
    Optional<Pays> findByNomPays(String pNomPays);
}
