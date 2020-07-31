package fr.cda.librairie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IAuteurDao;
import fr.cda.librairie.dto.AuteurDto;
import fr.cda.librairie.entity.Auteur;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.utils.Exception.AuteurPresentException;

@Service
public class AuteurServiceImpl implements IAuteurService {

	@Autowired
	IAuteurDao auteurDao;

	@Override
	public AuteurDto addAuteur(AuteurDto auteur) throws AuteurPresentException {
		Auteur aut = new Auteur();
		aut.setNom(auteur.getNom());
		aut.setPrenom(auteur.getPrenom());
		aut.setNomUsage(auteur.getNomUsuel());

		if (!auteurDao.existsByNomUsage(aut.getNomUsage())) {
			aut = auteurDao.save(aut);
			auteur.setId(aut.getId());
			auteur.setNom(aut.getNom());
			auteur.setNomUsuel(aut.getNomUsage());
			auteur.setPrenom(aut.getPrenom());
			return auteur;
		} else {
			throw new AuteurPresentException();
		}

	}

	@Override
	public void deleteAuteur(int id) {
		auteurDao.deleteById(id);
	}

	@Override
	public AuteurDto getAuteur(int id) {

		AuteurDto auteur = null;
		Optional<Auteur> resOp = auteurDao.findById(id);
		if (resOp.isPresent()) {
			auteur = new AuteurDto();
			Auteur aut = resOp.get();
			auteur.setNom(aut.getNom());
			auteur.setPrenom(aut.getPrenom());
			auteur.setNomUsuel(aut.getNomUsage());
			auteur.setId(aut.getId());

		}
		return auteur;
	}

	@Override
	public AuteurDto getAuteurByNom(String nom) {

		AuteurDto auteur = null;
		Optional<Auteur> resOp = auteurDao.findByNomUsage(nom);
		if (resOp.isPresent()) {
			auteur = new AuteurDto();
			Auteur aut = resOp.get();
			auteur.setNom(aut.getNom());
			auteur.setPrenom(aut.getPrenom());
			auteur.setNomUsuel(aut.getNomUsage());
			auteur.setId(aut.getId());

		}
		return auteur;
	}

	@Override
	public int getMaxId() {

		return auteurDao.getMaxId().intValue();
	}

	@Override
	public boolean existByName(String nom) {
		return auteurDao.existsByNomUsage(nom);
	}

}
