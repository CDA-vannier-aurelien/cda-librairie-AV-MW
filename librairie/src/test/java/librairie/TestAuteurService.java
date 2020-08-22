//package librairie;
//
//import fr.cda.librairie.dto.AuteurDto;
//import fr.cda.librairie.service.IAuteurService;
//import fr.cda.librairie.utils.Constantes;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(OrderAnnotation.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:spring/beans-configuration.xml")
//public class TestAuteurService {
//
//    @Autowired
//    private IAuteurService auteurService;
//
//    @Test
//    @Order(1)
//    public void testAddAuteur() throws Exception {
//
//        AuteurDto auteur = new AuteurDto();
//        auteur.setNom(Constantes.STRING_TEST);
//        auteur.setPrenom(Constantes.STRING_TEST);
//        auteur.setNomUsage(Constantes.STRING_TEST);
//        auteur = auteurService.addAuteur(auteur);
//        assertNotNull(auteur);
//        assertEquals(Constantes.STRING_TEST, auteur.getNom());
//        assertEquals(Constantes.STRING_TEST, auteur.getPrenom());
//        assertEquals(Constantes.STRING_TEST, auteur.getNomUsage());
//        assertEquals(auteurService.getMaxId(), auteur.getId());
//
//    }
//
//    @Test
//    @Order(2)
//    public void testGetAuteur() {
//
//        AuteurDto auteur = auteurService.getAuteur((int) auteurService.getMaxId());
//        assertNotNull(auteur);
//        assertEquals(Constantes.STRING_TEST, auteur.getNom());
//        assertEquals(Constantes.STRING_TEST, auteur.getPrenom());
//        assertEquals(Constantes.STRING_TEST, auteur.getNomUsage());
//        assertEquals(auteurService.getMaxId(), auteur.getId());
//
//    }
//
//    @Test
//    @Order(3)
//    public void testGetAuteurByNom() {
//        AuteurDto auteur = auteurService.getAuteurByNom(Constantes.STRING_TEST);
//        assertNotNull(auteur);
//        assertEquals(Constantes.STRING_TEST, auteur.getNom());
//        assertEquals(Constantes.STRING_TEST, auteur.getPrenom());
//        assertEquals(Constantes.STRING_TEST, auteur.getNomUsage());
//        assertEquals(auteurService.getMaxId(), auteur.getId());
//
//    }
//
//    @Test
//    @Order(4)
//    public void testExistByName() {
//        boolean verif = auteurService.existByName(Constantes.STRING_TEST);
//        assertTrue(verif);
//
//    }
//
//    @Test
//    @Order(5)
//    public void testDeleteAuteur() {
//        auteurService.deleteAuteur((int) auteurService.getMaxId());
//        AuteurDto auteur = auteurService.getAuteurByNom(Constantes.STRING_TEST);
//        assertNull(auteur);
//
//    }
//}
