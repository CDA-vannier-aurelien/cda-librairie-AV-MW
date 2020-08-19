package fr.cda.librairie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IAuteurDao;
import fr.cda.librairie.dao.IEditeurDao;
import fr.cda.librairie.dao.ILivreDao;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.entity.Auteur;
import fr.cda.librairie.entity.Editeur;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.service.ILivreService;

@Service
public class LivreServiceImpl implements ILivreService {

	@Autowired
	ILivreDao livreDao;

	@Autowired
	IAuteurDao auteurDao;

	@Autowired
	IEditeurDao editeurDao;

	@Override
	public LivreDto addLivre(LivreDto livre) {
		Livre livre2 = new Livre();
		livre2.setNbPage(livre.getNbPage());
		livre2.setPrix(livre.getPrix());
		livre2.setQuantitee(livre.getQuantitee());
		livre2.setTitre(livre.getTitre());
		livre2.setReference(livre.getReference());

		Optional<Auteur> opsRes = auteurDao.findByNomUsage(livre.getAuteur());
		if (opsRes.isPresent()) {
			livre2.setAuteur(opsRes.get());
		}
		Optional<Editeur> opsRes2 = editeurDao.findByNom(livre.getEditeur());
		if (opsRes.isPresent()) {
			livre2.setEditeur(opsRes2.get());
		}
		livre2 = livreDao.save(livre2);

		livre = this.getLivre(livre2.getReference());

		return livre;
	}

	@Override
	public void deleteLivre(int vRef) {

		livreDao.deleteById(vRef);

	}

	@Override
	public void updateQuantiteeLivre(int vQuantitee, int vRef) {

		Optional<Livre> optionelRes = livreDao.findById(vRef);
		Livre l = null;
		if (optionelRes.isPresent()) {
			l = optionelRes.get();
		}
		l.setQuantitee(vQuantitee);
		livreDao.save(l);
	}

	@Override
	public LivreDto getLivre(int vRef) {

		Optional<Livre> opsRes = livreDao.findById(vRef);
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

	@Override
	public int getMaxId() {
		return livreDao.getMaxId().intValue();
	}

}
