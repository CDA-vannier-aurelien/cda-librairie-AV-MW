package fr.cda.librairie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IPaysDao;
import fr.cda.librairie.dao.IRoleDao;
import fr.cda.librairie.dao.IRueDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dao.IVilleDao;
import fr.cda.librairie.dto.UtilisateurDto;
<<<<<<< HEAD
import fr.cda.librairie.dto.VilleDto;
import fr.cda.librairie.entity.*;
import fr.cda.librairie.exception.*;
=======
import fr.cda.librairie.entity.Pays;
import fr.cda.librairie.entity.Role;
import fr.cda.librairie.entity.User;
import fr.cda.librairie.entity.Ville;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
>>>>>>> Dev
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.BCrypt;

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

<<<<<<< HEAD
    @Autowired
    IAdresseDao iAdresseDao;

    @Override
    public UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException {
        User user = new User();
        String nomPays = pUser.getNomPays();
        Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays);
        if (!optionalPays.isPresent()) {
            throw new NomPaysException();
        }
        String nomVille = pUser.getNomVille();
        Optional<Ville> optionalVille = iVilleDao.findByNom(nomVille);
        if (!optionalVille.isPresent()) {
            throw new NomVilleIncorrect();
        }
        String nomRue = pUser.getNomRue();
        Optional<Rue> optionalRue = iRueDao.findByNom(nomRue);
        if (!optionalRue.isPresent()) {
            throw new NomRueException();
        }
        Adresse adresse = new Adresse();
        adresse.setVille(optionalVille.get());
        adresse.setPays(optionalPays.get());
        adresse.setRue(optionalRue.get());
        adresse.setNumero(pUser.getNumeroPorte());
        Optional<Adresse> optionalAdresse = iAdresseDao.findAdresseByRueAndPaysAndNumeroAndVille(adresse.getRue(), adresse.getPays(), adresse.getNumero(), adresse.getVille());
        if (optionalAdresse.isPresent()) {
            user.setAdresse(optionalAdresse.get());
        } else {
            user.setAdresse(adresse);
        }
        Optional<Role> optionalRole = iRoleDao.findByRole("Client");
        if (!optionalRole.isPresent()) {
            throw new RoleException();
        }
        user.setRole(optionalRole.get());
        user.setNom(pUser.getNom());
        user.setPrenom(pUser.getPrenom());
        user.setDateConnection(pUser.getDateConnection());
        user.setDateNaissance(pUser.getDateNaissance());
        user.setLogin(pUser.getLogin());
        user.setPassword(BCrypt.hashpw(pUser.getPassword(),BCrypt.gensalt(12)));
        iUserDao.save(user);

        return pUser;
    }

    @Override
    public UtilisateurDto checkLogin(UtilisateurDto pUser){
        Optional<User> user = iUserDao.getUserByLogin(pUser.getLogin());
        if(user.isPresent()){
            return pUser;
        }else{
            return null;
        }

    }
}
=======
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
>>>>>>> Dev

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
		user.setMail(pUser.getMail());
		user.setDateNaissance(pUser.getDateNaissance());
		user.setPassword(BCrypt.hashpw(pUser.getPassword(), BCrypt.gensalt(12)));
		iUserDao.save(user);
		return pUser;
	}

	@Override
	public UtilisateurDto conection(UtilisateurDto pUser) {
		
		
		
	// C'est gagnéééééééééééééééééééééééééééééééééééééééééééééééé
		// C'est bon j'suis chaud
		
		Optional<User> optionalUser=iUserDao.getUserByMail(pUser.getMail());
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
			pUser= UtilisateurDto.builder().nom(optionalUser.get().getNom()).prenom(optionalUser.get().getPrenom()).build();
			return pUser;
		
		}
		}
		
		return pUser;
	}

	@Override
	public UtilisateurDto checkMail(UtilisateurDto pUser) {
		 Optional<User> user = iUserDao.getUserByMail(pUser.getMail());
	        if(user.isPresent()){
	            return pUser;
	        }else{
	            return null;
	        }
	}


	

}
