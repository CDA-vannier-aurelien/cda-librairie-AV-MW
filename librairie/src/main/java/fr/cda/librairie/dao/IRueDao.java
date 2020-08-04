package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Rue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRueDao extends CrudRepository<Rue, Integer> {
    Optional<Rue> findByNom(String nomRue);
}
