package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.cda.librairie.entity.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserDao extends CrudRepository<User, String> {
    @Query(value = "select u.commandes from User u where u.id = :id" )
    List<Commande> getCommandesByUserIdOrderByDateDesc(@Param("id")int id);

}
