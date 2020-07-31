package fr.cda.librairie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.dao.IAuteurDao;
import fr.cda.librairie.entity.Auteur;
import fr.cda.librairie.service.IAuteurService;
import org.springframework.stereotype.Service;

@Service
public class AuteurServiceImpl implements IAuteurService {

	@Autowired
	IAuteurDao auteurDao;

	@Override
	public void addAuteur(Auteur auteur) {
		auteurDao.save(auteur);

	}

	@Override
	public void deleteAuteur(int id) {
		Auteur aut = getAuteur(id);

		if (aut != null) {
			auteurDao.delete(aut);
		}
	}

	@Override
	public Auteur getAuteur(int id) {
		Auteur aut = null;
		Optional<Auteur> resOp = auteurDao.findById(id);
		if (resOp.isPresent()) {
			aut = resOp.get();

		}
		return aut;
	}

	@Override
	public Auteur getAuteurByNom(String nom) {
		Auteur au = auteurDao.findByNomUsage(nom);
		return au;
	}

}
