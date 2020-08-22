package fr.cda.librairie.service;

import fr.cda.librairie.dto.LivreDto;

import java.util.List;

public interface ILivreService {
    public LivreDto addLivre(LivreDto livre);

    public void deleteLivre(int pRef);

    public void updateQuantiteeLivre(int vQuantitee, int vRef);

    public LivreDto getLivre(int pRef);

    public List<LivreDto> getAllLivre(int pPageEnCours);

    public int getMaxId();

    public boolean existByReference(int pRef);

    public long count();
}
