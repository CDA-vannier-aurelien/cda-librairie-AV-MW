package fr.cda.librairie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.IAuteurDao;
import fr.cda.librairie.dao.IEditeurDao;
import fr.cda.librairie.dao.ILivreDao;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.entity.Auteur;
import fr.cda.librairie.entity.Editeur;
import fr.cda.librairie.entity.Livre;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.utils.Constantes;

@Service
public class LivreServiceImpl implements ILivreService {

	@Autowired
	ILivreDao livreDao;

	@Autowired
	IAuteurDao auteurDao;

	@Autowired
	IEditeurDao editeurDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LivreDto addLivre(LivreDto livre) {
		Livre livre2 = new Livre();
		livre2.setNbPage(livre.getNbPage());
		livre2.setPrix(livre.getPrix());
		livre2.setQuantitee(livre.getQuantitee());
		livre2.setTitre(livre.getTitre());
		livre2.setReference(livre.getReference());
		livre2.setDescription(livre.getDescription());

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
					l.getAuteur().getNomUsage(), l.getDescription(), l.getEditeur().getNom());
		}

		return livre;
	}

	@Override
	public List<LivreDto> getAllLivre(int pPageEnCours) {
		List<LivreDto> listLivre = new ArrayList<LivreDto>();
		PageRequest page = PageRequest.of(pPageEnCours - 1, Constantes.ELEMENTS_PAGE);
		Page<Livre> livres = this.livreDao.findAll(page);
		for (Livre livre : livres) {
			LivreDto livre2 = new LivreDto(livre.getReference(), livre.getPrix(), livre.getQuantitee(),
					livre.getTitre(), livre.getNbPage(), livre.getAuteur().getNomUsage(), livre.getDescription(),
					livre.getEditeur().getNom());
			listLivre.add(livre2);
		}

		return listLivre;
	}

	@Override
	public int getMaxId() {
		return livreDao.getMaxId().intValue();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return livreDao.count();
	}

}
