package fr.cda.librairie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.ICommandeDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.service.ICommandeService;
import fr.cda.librairie.utils.Constantes;

@Service
public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	ICommandeDao iCommandeDao;

	@Autowired
	IUserDao iUserDao;
	@Autowired
	ModelMapper modelMapper;

	/**
	 * @param id Methode de suppression de commande par id
	 */
	@Override
	public void deleteCommandeById(int id) {
		this.iCommandeDao.removeByNumeroCommande(id);
	}

	/**
	 * @param id Methode de recherche de commandes par Id Client
	 * @return Retourne Arraylist de Commandes
	 */
	@Override
	public CommandeDto findById(int id) {
		Commande commande = null;
		Optional<Commande> resOp = this.iCommandeDao.findById(id);
		if (resOp.isPresent()) {
			commande = resOp.get();
		}
		return null;
	}

	/**
	 * @return Methode qui retourne une ArrayList de toutes les Commandes
	 */
	@Override
	public List<CommandeDto> findAll(int pPageEnCours) {

		PageRequest page = PageRequest.of(pPageEnCours - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<Commande> listCom = iCommandeDao.findCommandeByOrderByDateCommandeDesc(page);

		List<CommandeDto> listComs = new ArrayList<>();
		for (Commande commande : listCom) {

			CommandeDto maCom = this.modelMapper.map(commande, CommandeDto.class);
			maCom.setUserMail(iCommandeDao.getMailByNumCommande(commande.getNumeroCommande()));
			listComs.add(maCom);

		}
		return listComs;
	}

	/**
	 * @param pId Methode de recherche de commande par User
	 * @return Retourne une ArrayList de Commandes
	 */
	@Override
	public List<CommandeDto> findAllByUserOrderByDateDesc(int pId) {
		return null;
	}

	@Override
	public CommandeDto create(CommandeDto pCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return iCommandeDao.count();
	}
}