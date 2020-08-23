package fr.cda.librairie.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;

@Repository
/**
 * Interface permettant l'enregistrement des différents utilisateurs en base de
 * donnée.
 * 
 * @author PC
 *
 */
public interface IUserDao extends PagingAndSortingRepository<User, String> {
	@Query(value = "select u.commandes from User u where u.id = :id")
	List<Commande> getCommandesByUserIdOrderByDateDesc(@Param("id") int id);

	Optional<User> getUserByMail(String pUser);

	Optional<User> getUserById(int id);

	Page<User> findAll();

	Page<User> getUserByEstActive(boolean actif, Pageable page);

	@Transactional
	void removeByMail(String mail);



}
