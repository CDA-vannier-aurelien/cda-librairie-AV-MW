package fr.cda.librairie.dao;

import org.springframework.data.repository.CrudRepository;

import fr.cda.librairie.entity.User;

public interface IUserDao extends CrudRepository<User, String> {

}
