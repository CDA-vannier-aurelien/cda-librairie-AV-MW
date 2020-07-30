package fr.cda.librairie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.cda.librairie.dto.LivreDto;

@Service
public interface ILivreService {
	public void addLivre(LivreDto livre);

	public void deleteLivre(int id);

	public void updateLivre();

	public LivreDto getLivre(int id);

	public List<LivreDto> getAllLivre();
}
