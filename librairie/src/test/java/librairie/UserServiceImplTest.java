package librairie;

import fr.cda.librairie.configuration.ApplicationConfig;
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
@ContextConfiguration(classes = ApplicationConfig.class)
class UserServiceImplTest {
    @Autowired
    private IUserService iUserService;

    @Test
    void create() throws Exception {

        UtilisateurDto user = UtilisateurDto.builder().dateNaissance(new Date())
                .nom("benseddik3")
                .prenom("Fethi3")
                .mail("fe.benseddikc@gmail.com")
                .password("fethi")
                .nomRue("du nord prolongée")
                .numeroPorte(63)
                .ville("Anzin")
                .pays("FRANCE")
                .estActive(true)
                .dateConnection(new Date())
                .dateNaissance(new Date())
                .build();
        UtilisateurDto user1 = iUserService.create(user);
        assertNotNull(user1);

    }
}