package uipa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uipa.api.model.Usuario;

/**
 * UsuariosRepository
 */

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
  public Usuario findByLoginAndSenha(String nome, String senha);
  public List<Usuario> findByLoginContaining(String nome);
}
