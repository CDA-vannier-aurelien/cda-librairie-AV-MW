package fr.cda.librairie.service;

import fr.cda.librairie.dto.UserDto;
import fr.cda.librairie.entity.User;

public interface IUserService {

	void save(UserDto u);

	UserDto findByLogin(String login);

	boolean exists(String login, String password);



}
