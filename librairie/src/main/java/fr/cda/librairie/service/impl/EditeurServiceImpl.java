package fr.cda.librairie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.dao.IEditeurDao;
import fr.cda.librairie.entity.Editeur;
import fr.cda.librairie.service.IEditeurService;

public class EditeurServiceImpl implements IEditeurService {

	@Autowired
	IEditeurDao editeurDao;

	@Override
	public void addEditeur(Editeur editeur) {
		editeurDao.save(editeur);

	}

	@Override
	public void deleteEditeur(int id) {
		Editeur aut = this.getEditeur(id);

		if (aut != null) {
			editeurDao.delete(aut);
		}
	}

	@Override
	public Editeur getEditeur(int id) {
		Editeur aut = null;
		Optional<Editeur> resOp = editeurDao.findById(id);
		if (resOp.isPresent()) {
			aut = resOp.get();

		}
		return aut;
	}

	@Override
	public Editeur getEditeurByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
