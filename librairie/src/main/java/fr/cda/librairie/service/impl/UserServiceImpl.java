package fr.cda.librairie.service.impl;

import java.util.ArrayList;
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

import fr.cda.librairie.dao.ILivreDao;
import fr.cda.librairie.dao.IPaysDao;
import fr.cda.librairie.dao.IRoleDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dao.IVilleDao;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.CommandeLine;
import fr.cda.librairie.entity.Pays;
import fr.cda.librairie.entity.Role;
import fr.cda.librairie.entity.User;
import fr.cda.librairie.entity.Ville;
import fr.cda.librairie.exception.NomPaysException;
import fr.cda.librairie.exception.NomRueException;
import fr.cda.librairie.exception.NomVilleIncorrect;
import fr.cda.librairie.exception.RoleException;
import fr.cda.librairie.service.IUserService;
import fr.cda.librairie.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	IUserDao iUserDao;

	@Autowired
	IVilleDao iVilleDao;

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
	public UtilisateurDto create(UtilisateurDto pUser)
			throws NomVilleIncorrect, NomPaysException, NomRueException, RoleException {
		User user = new User();
		String nomPays = pUser.getPays();
		Optional<Pays> optionalPays = iPaysDao.findByNomPays(nomPays);
		if (!optionalPays.isPresent()) {

		}
		String nomVille = pUser.getVille();
		Optional<Ville> optionalVille = iVilleDao.findByNom(nomVille);
		if (!optionalVille.isPresent()) {
			throw new NomVilleIncorrect();
		}
		Optional<Role> optionalRole = iRoleDao.findByRole("Client");
		if (!optionalRole.isPresent()) {
			throw new RoleException();
		}
		user.setRole(optionalRole.get());
		user.setNom(pUser.getNom());
		user.setPrenom(pUser.getPrenom());
		user.setDateConnection(pUser.getDateConnection());
		user.setNumeroPorte(pUser.getNumeroPorte());
		user.setNomRue(pUser.getNomRue());
		user.setComplementAdresse(pUser.getComplementAdresse());
		user.setVille(optionalVille.get());
		user.setPays(optionalPays.get());
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
				pUser = UtilisateurDto.builder().mail(optionalUser.get().getMail()).nom(optionalUser.get().getNom())
						.prenom(optionalUser.get().getPrenom()).labelRole(optionalUser.get().getRole().getRole())
						.build();
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
	public List<UtilisateurDto> getAll(int pageEnCours) {

		List<UtilisateurDto> liste = new ArrayList<>();
		PageRequest page = PageRequest.of(pageEnCours - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<User> u = this.iUserDao.findAll(page);

		for (User user : u) {
			UtilisateurDto uDto = this.modelMapper.map(user, UtilisateurDto.class);
			uDto.setLabelRole(user.getRole().getRole());
			liste.add(uDto);

		}
		return liste;
	}

	@Override
	public long count() {
		return this.iUserDao.count();
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
	public UtilisateurDto update(UtilisateurDto pUser) throws NomVilleIncorrect, NomRueException {
		User user = new User();

		String nomVille = pUser.getVille();
		Optional<Ville> optionalVille = iVilleDao.findByNom(nomVille);
		if (!optionalVille.isPresent()) {
			throw new NomVilleIncorrect();
		}
		String nomRue = pUser.getNomRue();

		user.setNom(pUser.getNom());
		user.setPrenom(pUser.getPrenom());
		user.setDateConnection(pUser.getDateConnection());
		user.setNumeroPorte(pUser.getNumeroPorte());
		user.setNomRue(pUser.getNomRue());
		user.setComplementAdresse(pUser.getComplementAdresse());
		user.setVille(optionalVille.get());
		user.setMail(pUser.getMail());
		user.setDateNaissance(pUser.getDateNaissance());
		user.setPassword(bCryptPasswordEncoder.encode(pUser.getPassword()));
		iUserDao.save(user);

		return pUser;

	}

	@Override
	public UtilisateurDto getByMail(UtilisateurDto pUserDto) {
		Optional<User> vUserEntity = iUserDao.getUserByMail(pUserDto.getMail());

		pUserDto = this.modelMapper.map(vUserEntity.get(), UtilisateurDto.class);
		pUserDto.setVille(vUserEntity.get().getVille().getNom());
		pUserDto.setCodePostal(vUserEntity.get().getVille().getCodePostal());

		return pUserDto;
	}

}
