package fr.cda.librairie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.ICompteUserDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dto.UserDto;
import fr.cda.librairie.entity.CompteUser;
import fr.cda.librairie.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	private ICompteUserDao iCteDao;

	@Override
	public void save(UserDto u) {
		User vUser = new User();
		CompteUser vCte = new CompteUser();
		vUser.setNom(u.getNom());
		vUser.setPrenom(u.getPrenom());
		vCte.setLogin(u.getLogin());
		vCte.setPassword(u.getPassword());
	}

	@Override
	public boolean exists(String login, String password) {
		Optional<CompteUser> cteOpt = iCteDao.findById(login);
		boolean res = false;
		if (cteOpt.isPresent()) {
			res = password.equals(cteOpt.get().getPassword());
		}
		return res;
	}



	@Override
	public UserDto findByLogin(String login) {
		return iCteDao.findByLogin(login);
	}

}
