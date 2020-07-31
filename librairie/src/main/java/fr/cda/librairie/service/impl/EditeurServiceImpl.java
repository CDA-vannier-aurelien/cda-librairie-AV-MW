package fr.cda.librairie.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IEditeurDao;
import fr.cda.librairie.dto.EditeurDto;
import fr.cda.librairie.entity.Editeur;
import fr.cda.librairie.service.IEditeurService;
import org.springframework.stereotype.Service;

@Service
public class EditeurServiceImpl implements IEditeurService {

	@Autowired
	IEditeurDao editeurDao;

	@Override
	public EditeurDto addEditeur(EditeurDto editeur) {
		Editeur edit = new Editeur();
		edit.setNom(editeur.getNom());
		if (!editeurDao.existsByNom(edit.getNom())) {
			edit = editeurDao.save(edit);
			editeur.setId(edit.getId());
			editeur.setNom(edit.getNom());
			return editeur;

		}

		return null;

	}

	@Override
	public void deleteEditeur(int id) {
		editeurDao.deleteById(id);
	}

	@Override
	public EditeurDto getEditeur(int id) {
		EditeurDto editeur = null;
		Optional<Editeur> resOp = editeurDao.findById(id);
		if (resOp.isPresent()) {
			editeur = new EditeurDto();
			Editeur aut = resOp.get();
			editeur.setNom(aut.getNom());
			editeur.setId(aut.getId());
		}
		return editeur;
	}

	@Override
	public EditeurDto getEditeurByNom(String nom) {
		EditeurDto editeur = null;
		Optional<Editeur> resOp = editeurDao.findByNom(nom);
		if (resOp.isPresent()) {
			editeur = new EditeurDto();
			Editeur aut = resOp.get();
			editeur.setNom(aut.getNom());
			editeur.setId(aut.getId());
		}
		return editeur;
	}

	@Override
	public int getMaxId() {
		return editeurDao.getMaxId().intValue();
	}

	@Override
	public boolean existByName(String nom) {
		return editeurDao.existsByNom(nom);
	}

}
