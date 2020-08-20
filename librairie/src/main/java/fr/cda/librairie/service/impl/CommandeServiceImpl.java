package fr.cda.librairie.service.impl;

import fr.cda.librairie.dao.ICommandeDao;
import fr.cda.librairie.dao.IUserDao;
import fr.cda.librairie.dto.CommandeDto;
import fr.cda.librairie.entity.Commande;
import fr.cda.librairie.entity.User;
import fr.cda.librairie.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    ICommandeDao iCommandeDao;

    @Autowired
    IUserDao iUserDao;


    /**
     * @param id
     * Methode de suppression de commande par id
     */
    @Override
    public void deleteCommandeById(int id) {
        this.iCommandeDao.deleteById(id);
    }

    /**
     * @param id
     * Methode de recherche de commandes par Id Client
     * @return
     * Retourne Arraylist de Commandes
     */
    @Override
    public Commande findById(int id) {
        Commande commande = null;
        Optional<Commande> resOp = this.iCommandeDao.findById(id);
        if(resOp.isPresent()){
            commande = resOp.get();
        }
        return commande;
    }

    /**
     * @return
     * Methode qui retourne une ArrayList
     * de toutes les Commandes
     */
    @Override
    public List<Commande> findAll() {
       return (ArrayList<Commande>) this.iCommandeDao.findAll();
    }

    /**
     * @param pId
     * Methode de recherche de commande par User
     * @return
     * Retourne une ArrayList de Commandes
     *
     */
    @Override
    public List<Commande> findAllByUserOrderByDateDesc(int pId) {
        return this.iUserDao.getCommandesByUserIdOrderByDateDesc(pId);
    }

	@Override
	public CommandeDto create(CommandeDto pCommande) {
		// TODO Auto-generated method stub
		return null;
	}
}