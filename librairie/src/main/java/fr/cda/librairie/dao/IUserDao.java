package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * Interface permettant l'enregistrement des différents utilisateurs en base de donnée.
 * @author PC
 *
 */
public interface IUserDao extends CrudRepository<User, String> {
    @Query(value = "select u.commandes from User u where u.id = :id" )
    List<Commande> getCommandesByUserIdOrderByDateDesc(@Param("id")int id);
    Optional<User>getUserByLogin(String login);

}
