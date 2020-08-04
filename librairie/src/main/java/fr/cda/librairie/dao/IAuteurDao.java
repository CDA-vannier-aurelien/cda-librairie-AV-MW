package fr.cda.librairie.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Auteur;

@Repository
public interface IAuteurDao extends CrudRepository<Auteur, Integer> {

	public Optional<Auteur> findByNomUsage(String nomUsage);

	@Query("SELECT coalesce(max(ch.id), 0) FROM Auteur ch")
	public Long getMaxId();

	public boolean existsByNomUsage(String nomUsage);

}
