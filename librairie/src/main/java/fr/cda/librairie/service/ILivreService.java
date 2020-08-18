package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.LivreDto;

public interface ILivreService {
	public LivreDto addLivre(LivreDto livre);

	public void deleteLivre(int pRef);

	public void updateQuantiteeLivre(int vQuantitee, int vRef);

	public LivreDto getLivre(int pRef);

	public List<LivreDto> getAllLivre();

	public int getMaxId();
}
