package fr.cda.librairie.service;

import fr.cda.librairie.dto.CommandeLineDto;

import java.util.List;

public interface ICommandeLineService {

    List<CommandeLineDto>findCommandeLineByCommande_NumeroCommande(int numeroCommande);

}
