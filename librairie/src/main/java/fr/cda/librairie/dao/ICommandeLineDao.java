package fr.cda.librairie.dao;

import fr.cda.librairie.entity.CommandeLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeLineDao extends CrudRepository<CommandeLine, Integer> {
}
