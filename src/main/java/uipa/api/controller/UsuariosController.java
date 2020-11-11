package uipa.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uipa.api.dto.response.UsuarioResponseDTO;
import uipa.api.model.ApiMessage;
import uipa.api.model.Usuario;
import uipa.api.repository.UsuariosRepository;

/**
 * UsuariosController
 */

@RestController
@RequestMapping("api/usuarios")

public class UsuariosController {

  @Autowired
  private UsuariosRepository repository;

  @GetMapping
  public ResponseEntity<List<UsuarioResponseDTO>> todos() {
    List<Usuario> lista = repository.findAll();
    List<UsuarioResponseDTO> usuarios = lista.stream().map(usuario -> new UsuarioResponseDTO(usuario))
        .collect(Collectors.toList());
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }

  @GetMapping(path = "/nome/{nome}")
  public ResponseEntity<List<UsuarioResponseDTO>> porNome(@PathVariable String nome) {
    List<Usuario> lista = repository.findByLoginContaining(nome);
    List<UsuarioResponseDTO> usuarios = lista.stream().map(usuario -> new UsuarioResponseDTO(usuario))
        .collect(Collectors.toList());
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
  }

  @GetMapping(path = "/codusuario/{codusuario}")
  public ResponseEntity<Object> porCodUsuario(@PathVariable Integer codusuario) {
    Usuario usuario = repository.findById(codusuario).orElse(null);
    if (usuario != null)
      return new ResponseEntity<>(new UsuarioResponseDTO(usuario), HttpStatus.OK);
    return new ResponseEntity<>(new ApiMessage("Registro não encontrado"), HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<Object> salvar(@RequestBody Usuario usuario) {
    try {
      UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO(repository.save(usuario));
      return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(new ApiMessage("Este usuário já existe."), HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping(path = "/{codusuario}")
  public ResponseEntity<Object> delete(@PathVariable Integer codusuario) {

    try {
      Usuario usuario = repository.findById(codusuario).get();
      repository.delete(usuario);
      return new ResponseEntity<>(new ApiMessage(String.format("Usuario %s deletado com sucesso.", usuario.getLogin())),
          HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(new ApiMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
  }

}
