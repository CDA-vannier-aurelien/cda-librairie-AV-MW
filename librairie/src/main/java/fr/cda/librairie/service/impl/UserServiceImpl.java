package fr.cda.librairie.service.impl;

import fr.cda.librairie.dao.*;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.entity.*;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao iUserDao;

	@Autowired
	IVilleDao iVilleDao;

	@Autowired
	IPaysDao iPaysDao;

	@Autowired
	IRueDao iRueDao;

	@Autowired
	IRoleDao iRoleDao;

	@Override
	public UtilisateurDto create(UtilisateurDto pUser)
			throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException {
		User user = new User();
		String nomPays = pUser.getPays();
		Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays);
		if (!optionalPays.isPresent()) {
		
		}
		String nomVille = pUser.getVille();
		Optional<Ville> optionalVille = iVilleDao.findByNom(nomVille);
		if (!optionalVille.isPresent()) {
			throw new NomVilleIncorrect();
		}
//		String nomRue = pUser.getNomRue();
//		Optional<Rue> optionalRue = iRueDao.findByNom(nomRue);
//		if (!optionalRue.isPresent()) {
//			throw new NomRueException();
//		}

		Optional<Role> optionalRole = iRoleDao.findByRole("Client");
		if (!optionalRole.isPresent()) {
			throw new RoleException();
		}
		user.setRole(optionalRole.get());
		user.setNom(pUser.getNom());
		user.setPrenom(pUser.getPrenom());
		user.setDateConnection(pUser.getDateConnection());
//		user.setDateNaissance(pUser.getDateNaissance());
		user.setNumeroPorte(pUser.getNumeroPorte());
		user.setNomRue(pUser.getNomRue());
		user.setComplementAdresse(pUser.getComplementAdresse());
		user.setVille(optionalVille.get());
		user.setPays(optionalPays.get());
		user.setLogin(pUser.getMail());
		user.setDateNaissance(pUser.getDateNaissance());
		user.setPassword(BCrypt.hashpw(pUser.getPassword(), BCrypt.gensalt(12)));
		iUserDao.save(user);
		return pUser;
	}

	@Override
	public UtilisateurDto conection(UtilisateurDto pUser) {
		
		
		
	// C'est gagnéééééééééééééééééééééééééééééééééééééééééééééééé
		// C'est bon j'suis chaud
		
		Optional<User> optionalUser=iUserDao.findByLogin(pUser.getMail());
		if(!optionalUser.isPresent()) {
			System.out.println("erreur login");
			pUser=null;
		}else {
			if( !BCrypt.checkpw(pUser.getPassword(), optionalUser.get().getPassword())) {
				pUser=null;
				System.out.println("Erreur password");
			
		}else if( !optionalUser.get().isActivated()) {
			pUser=null;
			System.out.println("Erreur Compte inactif");
			
		}else {
			pUser.builder().nom(optionalUser.get().getNom()).prenom(optionalUser.get().getPrenom());
			System.out.println("Connecté !");
		}
		}
		
		return pUser;
	}

	

}