package librairie;

import fr.cda.librairie.dto.UtilisateurDto;
import fr.cda.librairie.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/beans-configuration.xml")
class UserServiceImplTest {
    @Autowired
    private IUserService iUserService;

    @Test
    void create() throws Exception {

       UtilisateurDto user = UtilisateurDto.builder()
                .nom("benseddik3")
                .prenom("Fethi3")
                .login("fethi3")
                .password("fethi")
                .nomRue("Truax")
                .numeroPorte(63)
                .nomVille("OZAN")
                .nomPays("Ghana")
                .isActivated(true)
                .dateConnection(new Date())
                .build();
           UtilisateurDto user1 =  iUserService.create(user);
          assertNotNull(user1);

    }
}