package fr.cda.librairie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IPaysDao;
import fr.cda.librairie.dao.IRoleDao;
import fr.cda.librairie.dao.IRueDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dao.IVilleDao;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;

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
		// TODO Auto-generated method stub
		return null;
	}
}

//    @Autowired
//    IAdresseDao iAdresseDao;

//    @Override
//    public UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException {
//        User user = new User();
//        String nomPays = pUser.getNomPays();
//        Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays);
//        if (!optionalPays.isPresent()) {
//            throw new NomPaysException();
//        }
//        String nomVille = pUser.getNomVille();
//        Optional<Ville> optionalVille = iVilleDao.findByNom(nomVille);
//        if (!optionalVille.isPresent()) {
//            throw new NomVilleIncorrect();
//        }
//        String nomRue = pUser.getNomRue();
//        Optional<Rue> optionalRue = iRueDao.findByNom(nomRue);
//        if (!optionalRue.isPresent()) {
//            throw new NomRueException();
//        }
//        Adresse adresse = new Adresse();
//        adresse.setVille(optionalVille.get());
//        adresse.setPays(optionalPays.get());
//        adresse.setRue(optionalRue.get());
//        adresse.setNumero(pUser.getNumeroPorte());
//        Optional<Adresse> optionalAdresse = iAdresseDao.findAdresseByRueAndPaysAndNumeroAndVille(adresse.getRue(), adresse.getPays(), adresse.getNumero(), adresse.getVille());
//        if (optionalAdresse.isPresent()) {
//            user.setAdresse(optionalAdresse.get());
//        } else {
//            user.setAdresse(adresse);
//        }
//        Optional<Role> optionalRole = iRoleDao.findByRole("Client");
//        if (!optionalRole.isPresent()) {
//            throw new RoleException();
//        }
//        user.setRole(optionalRole.get());
//        user.setNom(pUser.getNom());
//        user.setPrenom(pUser.getPrenom());
//        user.setDateConnection(pUser.getDateConnection());
//        user.setDateNaissance(pUser.getDateNaissance());
//        user.setLogin(pUser.getLogin());
//        user.setPassword(BCrypt.hashpw(pUser.getPassword(),BCrypt.gensalt(12)));
//        iUserDao.save(user);
//        return pUser;
//    }
//}
