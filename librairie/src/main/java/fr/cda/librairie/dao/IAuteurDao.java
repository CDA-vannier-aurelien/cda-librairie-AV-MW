package fr.cda.librairie.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Auteur;

/**
 * 
 * Interface permettant d'interagir avec la base de donnée concernant les
 * éléments propre à chaque auteur de livres.
 * 
 * @author Matthieu
 *
 */
@Repository
public interface IAuteurDao extends CrudRepository<Auteur, Integer> {

	public Optional<Auteur> findByNomUsage(String nomUsage);

	@Query("SELECT coalesce(max(ch.id), 0) FROM Auteur ch")
	public Long getMaxId();

	public boolean existsByNomUsage(String nomUsage);

	public List<Auteur> findByNomUsageContaining(String Auteur);

}
