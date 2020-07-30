package fr.cda.librairie.service;

import fr.cda.librairie.dto.UserDto;

public interface IUserService {

	void save(UserDto u);

	UserDto findByLogin(String login);

	boolean exists(String login, String password);

}
