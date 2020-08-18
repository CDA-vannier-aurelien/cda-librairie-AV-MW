package librairie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.cda.librairie.dto.EditeurDto;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.utils.Constantes;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/beans-configuration.xml")
public class TestEditeurService {

@Autowired
private  IEditeurService editeurService;


	@Test
	@Order(1)
	public void testAddediteur() {

		EditeurDto editeur = new EditeurDto();
		editeur.setNom(Constantes.STRING_TEST);
		editeur = editeurService.addEditeur(editeur);
		assertNotNull(editeur);
		assertEquals(Constantes.STRING_TEST, editeur.getNom());
		assertEquals(editeurService.getMaxId(), editeur.getId());

	}

	@Test
	@Order(2)
	public void testGetediteur() {

		EditeurDto editeur = editeurService.getEditeur((int) editeurService.getMaxId());
		assertNotNull(editeur);
		assertEquals(Constantes.STRING_TEST, editeur.getNom());
		assertEquals(editeurService.getMaxId(), editeur.getId());

	}

	@Test
	@Order(3)
	public void testGetediteurByNom() {
		EditeurDto editeur = editeurService.getEditeurByNom(Constantes.STRING_TEST);
		assertNotNull(editeur);
		assertEquals(Constantes.STRING_TEST, editeur.getNom());
		assertEquals(editeurService.getMaxId(), editeur.getId());

	}

	@Test
	@Order(4)
	public void testExistByName() {
		boolean verif = editeurService.existByName(Constantes.STRING_TEST);
		assertTrue(verif);

	}

	@Test
	@Order(5)
	public void testDeleteediteur() {
		editeurService.deleteEditeur((int) editeurService.getMaxId());
		EditeurDto editeur = editeurService.getEditeurByNom(Constantes.STRING_TEST);
		assertNull(editeur);

	}
}
