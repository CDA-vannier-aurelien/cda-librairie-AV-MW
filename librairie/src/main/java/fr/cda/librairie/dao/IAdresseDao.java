package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Adresse;
import fr.cda.librairie.entity.Pays;
import fr.cda.librairie.entity.Rue;
import fr.cda.librairie.entity.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IAdresseDao extends CrudRepository<Adresse, Integer> {
    Optional<Adresse>findAdresseByRueAndPaysAndNumeroAndVille(Rue rue, Pays pays, int numero, Ville ville);

}
