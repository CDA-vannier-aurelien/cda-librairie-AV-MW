package fr.cda.librairie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Auteur;

@Repository
public interface IAuteurDao extends CrudRepository<Auteur, Integer> {

	public Auteur findByNomUsage(String nomUsage);

}
