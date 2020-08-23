package fr.cda.librairie.service;

import java.util.List;

import fr.cda.librairie.dto.CommandeDto;

public interface ICommandeService {

	public void deleteCommandeById(int id);

	public CommandeDto findById(int id);

	public List<CommandeDto> findAll(int pPageEnCours);

	public List<CommandeDto> findAllByUserOrderByDateDesc(int pId);

	CommandeDto create(CommandeDto pCommande);

	public long count();
}
