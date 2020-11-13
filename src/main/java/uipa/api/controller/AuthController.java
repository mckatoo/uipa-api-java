package uipa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uipa.api.model.Usuario;
import uipa.api.repository.UsuariosRepository;

@RestController
@RequestMapping("api/auth")

public class AuthController {
    
  @Autowired
  private UsuariosRepository repository;

  @PostMapping
  public ResponseEntity<Object> login(@RequestBody Usuario usuario) {
    // try {
    //   UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO(repository.save(usuario));
    //   return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    // } catch (Exception e) {
    //   return new ResponseEntity<>(new ApiMessage("Este usuário já existe."), HttpStatus.BAD_REQUEST);
    // }
    return null;
  }
}
