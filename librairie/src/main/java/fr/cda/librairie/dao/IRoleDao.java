package fr.cda.librairie.dao;

import fr.cda.librairie.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IRoleDao extends CrudRepository<Role, Integer> {
    Optional<Role> findByRole(String pRole);
}
