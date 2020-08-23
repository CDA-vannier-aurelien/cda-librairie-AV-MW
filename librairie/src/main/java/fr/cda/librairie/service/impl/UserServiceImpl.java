package fr.cda.librairie.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cda.librairie.dao.ICommandeDao;
import fr.cda.librairie.dao.ILivreDao;
import fr.cda.librairie.dao.IPaysDao;
import fr.cda.librairie.dao.IRoleDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dao.IVilleDao;
import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.CommandeLine;
import fr.cda.librairie.entity.Pays;
import fr.cda.librairie.entity.Role;
import fr.cda.librairie.entity.User;
import fr.cda.librairie.entity.Ville;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import fr.cda.librairie.utils.Tools;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao iUserDao;

	@Autowired
	IVilleDao iVilleDao;
	@Autowired
	ICommandeDao iCommandeDao;
	@Autowired
	ILivreDao iLivreDao;

	@Autowired
	IPaysDao iPaysDao;

	@Autowired
	IRoleDao iRoleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UtilisateurDto create(UtilisateurDto pUser) {
		User user = new User();
		String nomPays = pUser.getPays();
		Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays.toUpperCase());
		if (!optionalPays.isPresent()) {
			Pays pays = new Pays(pUser.getPays().toUpperCase());
			iPaysDao.save(pays);
			Optional<Pays> optionalPays2 = iPaysDao.findByNomPays(nomPays.toUpperCase());
			user.setPays(optionalPays2.get());

		} else {
			user.setPays(optionalPays.get());
		}
		pUser.getVille();
		Optional<Ville> optionalVille = iVilleDao.findByNomAndCodePostal(pUser.getVille().toUpperCase(),
				pUser.getCodePostal());
		if (!optionalVille.isPresent()) {
			Ville ville = new Ville(pUser.getVille().toUpperCase(), pUser.getCodePostal());
			iVilleDao.save(ville);
			Optional<Ville> optionalVille2 = iVilleDao.findByNomAndCodePostal(pUser.getVille().toUpperCase(),
					pUser.getCodePostal());
			user.setVille(optionalVille2.get());

		} else {
			user.setVille(optionalVille.get());
		}
		Optional<Role> optionalRole = iRoleDao.findByRole("Client");

		user.setRole(optionalRole.get());
		user.setNom(Tools.capitalize(pUser.getNom()));
		user.setPrenom(Tools.capitalize(pUser.getPrenom()));
		user.setDateConnection(pUser.getDateConnection());
		user.setNumeroPorte(pUser.getNumeroPorte());
		user.setNomRue(pUser.getNomRue());
		user.setComplementAdresse(pUser.getComplementAdresse());
		user.setMail(pUser.getMail());
		user.setDateNaissance(pUser.getDateNaissance());
		user.setPassword(bCryptPasswordEncoder.encode(pUser.getPassword()));
		iUserDao.save(user);
		return pUser;
	}

	@Override
	public UtilisateurDto conection(UtilisateurDto pUser) {

		Optional<User> optionalUser = iUserDao.getUserByMail(pUser.getMail());
		if (!optionalUser.isPresent()) {
			log.warn("erreur login");
			pUser = null;
		} else {
			if (!bCryptPasswordEncoder.matches(pUser.getPassword(), optionalUser.get().getPassword())) {
				pUser = null;
				log.warn("Erreur password");

			} else if (!optionalUser.get().isEstActive()) {
				pUser = null;
				log.warn("Erreur Compte inactif");

			} else {
				optionalUser.get().setDateConnection(new Date());
				iUserDao.save(optionalUser.get());

				pUser = UtilisateurDto.builder().mail(optionalUser.get().getMail()).nom(optionalUser.get().getNom())
						.prenom(optionalUser.get().getPrenom()).labelRole(optionalUser.get().getRole().getRole())
						.dateConnection(optionalUser.get().getDateConnection()).id(optionalUser.get().getId()).build();
				log.info("ajout avec succ�s");
				return pUser;

			}
		}

		return pUser;
	}

	@Override
	public UtilisateurDto checkMail(UtilisateurDto pUser) {
		Optional<User> user = iUserDao.getUserByMail(pUser.getMail());
		if (user.isPresent()) {
			return pUser;
		} else {
			return null;
		}
	}

	@Override
	public List<UtilisateurDto> getAll(int pageEnCours, boolean verif) {

		List<UtilisateurDto> liste = new ArrayList<>();
		PageRequest page = PageRequest.of(pageEnCours - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<User> u = this.iUserDao.getUserByEstActive(verif, page);

		for (User user : u) {
			UtilisateurDto uDto = this.modelMapper.map(user, UtilisateurDto.class);
			uDto.setLabelRole(user.getRole().getRole());
			uDto.setVille(user.getVille().getNom());
			uDto.setCodePostal(user.getVille().getCodePostal());
			liste.add(uDto);

		}
		return liste;
	}

	@Override
	public long count() {
		return this.iUserDao.count();
	}

	@Override
	public long countCommandeByMail(String mail) {
		return iUserDao.getUserByMail(mail).get().getCommandes().size();
	}

	@Override
	public void passerCommande(UtilisateurDto user, HashMap<LivreDto, Integer> maCmd) {
		Optional<User> optionalUser = iUserDao.getUserByMail(user.getMail());
		User utilisateur = optionalUser.get();
		optionalUser.get().setEstActive(true);
		Commande commande = new Commande();
		for (Map.Entry<LivreDto, Integer> entry : maCmd.entrySet()) {
			CommandeLine cmdLine = new CommandeLine();
			cmdLine.setLivre(iLivreDao.findById(entry.getKey().getReference()).get());
			cmdLine.setQuantiteCommandee(entry.getValue());
			cmdLine.setCommande(commande);
			commande.getCommandeLine().add(cmdLine);
		}

		utilisateur.getCommandes().add(commande);
		iUserDao.save(utilisateur);
	}

	@Override
	public UtilisateurDto update(UtilisateurDto pUser) {
		Optional<User> user = iUserDao.getUserByMail(pUser.getMail());
		String nomPays = pUser.getPays();
		Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays.toUpperCase());
		if (!optionalPays.isPresent()) {
			Pays pays = new Pays(pUser.getPays().toUpperCase());
			iPaysDao.save(pays);
			Optional<Pays> optionalPays2 = iPaysDao.findByNomPays(nomPays.toUpperCase());
			user.get().setPays(optionalPays2.get());

		} else {
			user.get().setPays(optionalPays.get());
		}

		Optional<Ville> optionalVille = iVilleDao.findByNomAndCodePostal(pUser.getVille().toUpperCase(),
				pUser.getCodePostal());
		if (!optionalVille.isPresent()) {
			Ville ville = new Ville(pUser.getVille().toUpperCase(), pUser.getCodePostal());
			iVilleDao.save(ville);
			Optional<Ville> optionalVille2 = iVilleDao.findByNomAndCodePostal(pUser.getVille().toUpperCase(),
					pUser.getCodePostal());
			user.get().setVille(optionalVille2.get());

		} else {
			user.get().setVille(optionalVille.get());
		}

		if (!pUser.getPassword().equals("")) {
			user.get().setPassword(bCryptPasswordEncoder.encode(pUser.getPassword()));
		}

		user.get().setNom(Tools.capitalize(pUser.getNom()));
		user.get().setPrenom(Tools.capitalize(pUser.getPrenom()));
		user.get().setNumeroPorte(pUser.getNumeroPorte());
		user.get().setNomRue(pUser.getNomRue());
		user.get().setComplementAdresse(pUser.getComplementAdresse());

		iUserDao.save(user.get());

		return pUser;

	}

	@Override
	public UtilisateurDto getByMail(UtilisateurDto pUserDto) {
		Optional<User> vUserEntity = iUserDao.getUserByMail(pUserDto.getMail());

		pUserDto = this.modelMapper.map(vUserEntity.get(), UtilisateurDto.class);
		pUserDto.setVille(vUserEntity.get().getVille().getNom());
		pUserDto.setCodePostal(vUserEntity.get().getVille().getCodePostal());
		log.debug(pUserDto.getId() + "");
		return pUserDto;
	}

	@Override
	public void deleteUtilisateur(String email) {
		iUserDao.removeByMail(email);

	}

	@Override
	public void activeCompte(String mail) {

		Optional<User> vUser = iUserDao.getUserByMail(mail);
		vUser.get().setEstActive(Boolean.TRUE);
		iUserDao.save(vUser.get());

	}

	@Override
	public List<CommandeDto> getCommandeById(int id, int pPageEnCours) {
		PageRequest page = PageRequest.of(pPageEnCours - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<Commande> pageCommande = iCommandeDao.getCommandeByIdUser(page, id);
		List<CommandeDto> list = new ArrayList<>();
		for (Commande iterable_element : pageCommande) {
			CommandeDto commande = this.modelMapper.map(iterable_element, CommandeDto.class);
			list.add(commande);
		}
		return list;
	}

	@Override
	public void deleteCommandeByIdCommande(int idCommande, String mail) {
		Optional<User> optionalUser = iUserDao.getUserByMail(mail);
		for (Commande commande : optionalUser.get().getCommandes()) {
			if (commande.getNumeroCommande() == idCommande) {
				optionalUser.get().getCommandes().remove(commande);
				break;
			}
		}
		iUserDao.save(optionalUser.get());
		iCommandeDao.removeByNumeroCommande(idCommande);

	}

}
