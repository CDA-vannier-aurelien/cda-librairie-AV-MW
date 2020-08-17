package librairie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.service.IEditeurService;
import fr.cda.librairie.service.ILivreService;
import fr.cda.librairie.utils.ContextConfigurationType;
import fr.cda.librairie.utils.ContextFactory;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/beans-configuration.xml")
public class TestLivreService {
	private IEditeurService editeurService;
	private ILivreService livreService;
	private  IAuteurService auteurService;


@Test
@Order(1)
	public void testAddLivre() {

	}

@Test
@Order(6)
	public void testDeleteLivre() {

	}

@Test
@Order(2)
	public void testUpdateLivre() {

	}

@Test
@Order(3)
	public void testGetLivre() {

	}

@Test
@Order(4)
	public void testGetAllLivre() {

	}

@Test
@Order(5)
	public void testGetMaxId() {

	}

}
