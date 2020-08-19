package librairie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.cda.librairie.dto.AuteurDto;
import fr.cda.librairie.dto.EditeurDto;
import fr.cda.librairie.dto.LivreDto;
import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.utils.Constantes;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/beans-configuration.xml")
public class TestLivreService {
	@Autowired
	private IEditeurService editeurService;
	@Autowired
	private ILivreService livreService;
	@Autowired
	private IAuteurService auteurService;

	@Test
	@Order(1)
	public void testAddLivre() throws Exception {
		AuteurDto auteur = new AuteurDto();
		auteur.setNom(Constantes.STRING_TEST);
		auteur.setPrenom(Constantes.STRING_TEST);
		auteur.setNomUsuel(Constantes.STRING_TEST);
		EditeurDto editeur = new EditeurDto();
		editeur.setNom(Constantes.STRING_TEST);
		editeur = editeurService.addEditeur(editeur);
		auteur = auteurService.addAuteur(auteur);

		LivreDto livre = new LivreDto(Constantes.INTEGER_TEST, Constantes.DOUBLE_TEST, Constantes.INTEGER_TEST,
				Constantes.STRING_TEST, Constantes.INTEGER_TEST, Constantes.STRING_TEST, Constantes.STRING_TEST,
				Constantes.STRING_TEST);

		livre = livreService.addLivre(livre);

		assertNotNull(livre);
		assertEquals(Constantes.INTEGER_TEST, livre.getReference());
		assertEquals(Constantes.INTEGER_TEST, livre.getNbPage());
		assertEquals(Constantes.DOUBLE_TEST, livre.getPrix());
		assertEquals(Constantes.INTEGER_TEST, livre.getQuantitee());
		assertEquals(Constantes.STRING_TEST, livre.getAuteur());
		assertEquals(Constantes.STRING_TEST, livre.getEditeur());
		assertEquals(Constantes.STRING_TEST, livre.getTitre());

	}

	@Test
	@Order(6)
	public void testDeleteLivre() {
		livreService.deleteLivre(Constantes.INTEGER_TEST);
		auteurService.deleteAuteur((int) auteurService.getMaxId());
		editeurService.deleteEditeur((int) editeurService.getMaxId());
		LivreDto livre = livreService.getLivre(Constantes.INTEGER_TEST);
		assertNull(livre);

	}

	@Test
	@Order(3)
	public void testUpdateLivre() {

		livreService.updateQuantiteeLivre(5, Constantes.INTEGER_TEST);
		LivreDto livre = livreService.getLivre(Constantes.INTEGER_TEST);
		assertNotNull(livre);
		assertEquals(livre.getQuantitee(), 5);

	}

	@Test
	@Order(2)
	public void testGetLivre() {

		LivreDto livre = livreService.getLivre(Constantes.INTEGER_TEST);
		assertNotNull(livre);
		assertEquals(Constantes.INTEGER_TEST, livre.getReference());
		assertEquals(Constantes.INTEGER_TEST, livre.getNbPage());
		assertEquals(Constantes.DOUBLE_TEST, livre.getPrix());
		assertEquals(Constantes.INTEGER_TEST, livre.getQuantitee());
		assertEquals(Constantes.STRING_TEST, livre.getAuteur());
		assertEquals(Constantes.STRING_TEST, livre.getEditeur());
		assertEquals(Constantes.STRING_TEST, livre.getTitre());

	}

	@Test
	@Order(4)
	public void testGetAllLivre() {

		List<LivreDto> listeLivre = livreService.getAllLivre(Constantes.INTEGER_TEST);
		assertNotNull(listeLivre);

	}

}
