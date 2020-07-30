package fr.cda.librairie.dao;

import org.springframework.data.repository.CrudRepository;

import fr.cda.librairie.dto.UserDto;
import fr.cda.librairie.entity.CompteUser;

public interface ICompteUserDao extends CrudRepository<CompteUser, String> {

	CompteUser findByLoginAndPassword(String login, String password);

	UserDto findByLogin(String login);

}
