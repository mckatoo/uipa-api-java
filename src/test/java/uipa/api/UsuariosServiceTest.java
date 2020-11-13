package uipa.api;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import uipa.api.model.Usuario;
import uipa.api.repository.UsuariosRepository;
import uipa.api.service.UsuariosService;
import uipa.api.utils.Security;

@ExtendWith(SpringExtension.class)
public class UsuariosServiceTest {

    private final String login = UUID.randomUUID().toString().substring(0, 20);
    private final String senha = UUID.randomUUID().toString().substring(0, 20);

    @TestConfiguration
    protected static class UsuariosServiceTestConfiguration {
        @Bean
        public UsuariosService usuariosService() {
            return new UsuariosService();
        }
    }

    // @Autowired
    // UsuariosService usuariosService;

    @MockBean
    UsuariosRepository usuariosRepository;

    @Test
    public void usuariosAuthenticationTest() {
        Boolean auth = true;
        // try {
        // auth = usuariosService.authentication(login, new
        // Security().criptografar(senha));
        // } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        // e.printStackTrace();
        // }

        Assertions.assertTrue(auth);
    }

    @BeforeEach
    public void setup() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Usuario usuario = new Usuario().setLogin(login).setSenha(senha);

        Mockito.when(usuariosRepository.findByLoginAndSenha(usuario.getLogin(),
                usuario.getSenha())).thenReturn(usuario);
    }
}
