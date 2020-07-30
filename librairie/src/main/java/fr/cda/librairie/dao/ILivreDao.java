package fr.cda.librairie.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Livre;

@Repository
public interface ILivreDao extends CrudRepository<Livre, Integer> {

	public List<Livre> findAll();

}
