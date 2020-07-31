package fr.cda.librairie.service.impl;

import fr.cda.librairie.dao.*;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.entity.*;
import fr.cda.librairie.exeption.NomPaysException;
import fr.cda.librairie.exeption.NomRueExecption;
import fr.cda.librairie.exeption.NomVilleIncorrect;
import fr.cda.librairie.exeption.RoleExecption;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    IAdresseDao iAdresseDao;

    @Override
    public UtilisateurDto create(UtilisateurDto pUser) throws NomVilleIncorrect, NomPaysException, NomRueExecption, RoleExecption {
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
            throw new NomRueExecption();
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
            throw new RoleExecption();
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
}




