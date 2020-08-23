package fr.cda.librairie.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.cda.librairie.entity.Commande;

/**
 * Interface permetant l'ajout des commandes en base de donnée.
 *
 * @author Fethi
 */
@Repository
public interface ICommandeDao extends PagingAndSortingRepository<Commande, Integer> {
	@Query(value = "select * from commande c\n" +
			"join utilisateur_commande cu on c.numero_commande = cu.commandes_numero_commande\n" +
			"join utilisateur u on u.id = cu.User_id \n" +
			"where u.id= :id ", nativeQuery = true)
	Page<Commande>


	Optional<Commande> findById(Integer integer);

	@Transactional
	void removeByNumeroCommande(int id);

	Page<Commande> findCommandeByOrderByDateCommandeDesc(Pageable page);

	@Query(value = "select mail from utilisateur join utilisateur_commande cu on utilisateur.id = cu.User_id join commande c on c.numero_commande = cu.commandes_numero_commande where c.numero_commande = :numCom", nativeQuery = true)
	String getMailByNumCommande(@Param("numCom") int numCom);
}
