package fr.cda.librairie.service;

import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.entity.Commande;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICommandeService {


    public void deleteCommandeById(int id);

    public Commande findById(int id);

    public List<Commande> findAll();

    public List<Commande> findAllByUserOrderByDateDesc(int pId);

    CommandeDto create(CommandeDto pCommande);
}
