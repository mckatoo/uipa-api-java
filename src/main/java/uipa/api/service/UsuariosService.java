package uipa.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uipa.api.model.Usuario;
import uipa.api.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    public Boolean authentication(String login, String password) {
        Usuario usuario = usuariosRepository.findByLoginAndSenha(login, password);
        if (usuario != null) {
            return true;
        }
        return false;
    }

}
