package uipa.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uipa.api.model.Usuario;

/**
 * UsuariosRepository
 */

@Repository

public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
  public Usuario getByCodUsuario(Integer CodUsuario);
}
