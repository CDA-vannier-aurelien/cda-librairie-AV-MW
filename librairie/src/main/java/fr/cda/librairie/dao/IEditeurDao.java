package fr.cda.librairie.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Editeur;

@Repository

/**
 * Interface permettant l'enrgestriement des informations concernant les
 * editeurs en base de donnée.
 * 
 * @author PC
 *
 */
public interface IEditeurDao extends CrudRepository<Editeur, Integer> {
	public Optional<Editeur> findByNom(String nom);

	@Query("SELECT coalesce(max(ch.id), 0) FROM Editeur ch")
	public Long getMaxId();

	public boolean existsByNom(String nomUsage);

	public List<Editeur> findAll();

}
