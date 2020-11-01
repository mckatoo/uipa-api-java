package uipa.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uipa.api.dto.request.UsuarioRequestDTO;
import uipa.api.dto.response.UsuarioResponseDTO;
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

  @GetMapping(path = "/id/{CodUsuario}")
  public ResponseEntity<UsuarioResponseDTO> porCodUsuario(@PathVariable Integer CodUsuario) {
    Usuario usuario = repository.getByCodUsuario(CodUsuario);
    if (usuario != null)
      return new ResponseEntity<>(new UsuarioResponseDTO(usuario), HttpStatus.OK);
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity<UsuarioResponseDTO> salvar(@RequestBody Usuario usuario) {
    UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO(repository.save(usuario));
    return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
  }

}
