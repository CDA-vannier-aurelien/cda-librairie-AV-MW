package fr.cda.librairie.service.impl;

import fr.cda.librairie.dao.ICommandeLineDao;
import fr.cda.librairie.dto.CommandeLineDto;
import fr.cda.librairie.entity.CommandeLine;
import fr.cda.librairie.service.ICommandeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommadeLineServiceImpl implements ICommandeLineService {
@Autowired
private ICommandeLineDao iCommandeLineDao;
    @Override
    public List<CommandeLineDto> findCommandeLineByCommande_NumeroCommande(int numeroCommande) {
        List<CommandeLineDto> commandeLineDtoList = new ArrayList<>();
        List <CommandeLine> listLine =  iCommandeLineDao.findCommandeLineByCommande_NumeroCommande(numeroCommande);
        for (CommandeLine commandeLine : listLine) {
            CommandeLineDto commandeLineDto = CommandeLineDto.builder()
                    .nomLivre(commandeLine.getLivre().getTitre())
                    .prixLivre(commandeLine.getLivre().getPrix())
                    .quantiteCommandee(commandeLine.getQuantiteCommandee()).build();
            commandeLineDtoList.add(commandeLineDto);
        }

        return commandeLineDtoList;
    }
}
