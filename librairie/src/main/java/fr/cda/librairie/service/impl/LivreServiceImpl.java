package fr.cda.librairie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cda.librairie.dao.ILivreDao;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;

public class LivreServiceImpl implements ILivreService {

	@Autowired
	ILivreDao livreDao;

	@Autowired
	IAuteurService auteurService;

	@Autowired
	IEditeurService editeurService;

	@Override
	public void addLivre(LivreDto livre) {
		Livre livre2 = new Livre();
		livre2.setNbPage(livre.getNbPage());
		livre2.setPrix(livre.getPrix());
		livre2.setQuantitee(livre.getQuantitee());
		livre2.setTitre(livre.getTitre());
		livre2.setReference(livre.getReference());
		livre2.setAuteur(auteurService.getAuteurByNom(livre.getAuteur()));
		livre2.setEditeur(editeurService.getEditeurByNom(livre.getEditeur()));
		livreDao.save(livre2);

	}

	@Override
	public void deleteLivre(int id) {
		LivreDto l = this.getLivre(id);
		Livre livre = new Livre();
		livre.setNbPage(l.getNbPage());
		livre.setPrix(l.getPrix());
		livre.setQuantitee(l.getQuantitee());
		livre.setTitre(l.getTitre());
		livre.setReference(l.getReference());
		livre.setAuteur(auteurService.getAuteurByNom(l.getAuteur()));
		livre.setEditeur(editeurService.getEditeurByNom(l.getEditeur()));
		livreDao.delete(livre);

	}

	@Override
	public void updateLivre() {
		// TODO Auto-generated method stub

	}

	@Override
	public LivreDto getLivre(int id) {

		Optional<Livre> opsRes = livreDao.findById(id);
		LivreDto livre = null;
		if (opsRes.isPresent()) {
			Livre l = opsRes.get();
			livre = new LivreDto(l.getReference(), l.getPrix(), l.getQuantitee(), l.getTitre(), l.getNbPage(),
					l.getAuteur().getNomUsage(), l.getEditeur().getNom());
		}

		return livre;
	}

	@Override
	public List<LivreDto> getAllLivre() {
		List<Livre> listLivre = livreDao.findAll();

		List<LivreDto> listLivreDto = new ArrayList<>();

		for (Livre livre : listLivre) {
			LivreDto livre2 = new LivreDto(livre.getReference(), livre.getPrix(), livre.getQuantitee(),
					livre.getTitre(), livre.getNbPage(), livre.getAuteur().getNomUsage(), livre.getEditeur().getNom());
			listLivreDto.add(livre2);
		}
		return listLivreDto;
	}

}
