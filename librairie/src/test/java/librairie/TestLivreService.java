package librairie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;

import fr.cda.librairie.service.IAuteurService;
import fr.cda.librairie.utils.ContextConfigurationType;
import fr.cda.librairie.utils.ContextFactory;

@TestMethodOrder(OrderAnnotation.class)
public class TestLivreService {
	private static ApplicationContext context;
	private static IAuteurService auteurService;

	@BeforeAll
	public static void initAll() {
		context = ContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		auteurService = context.getBean(IAuteurService.class);
	}

	public void testAddLivre() {

	}

	public void testDeleteLivre() {

	};

	public void testUpdateLivre() {

	}

	public void testGetLivre() {

	}

	public void testGetAllLivre() {

	};

	public void testGetMaxId() {

	};

}
