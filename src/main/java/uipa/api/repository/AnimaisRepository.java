package uipa.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uipa.api.model.Animal;

/**
 * UsuariosRepository
 */

@Repository

public interface AnimaisRepository extends JpaRepository<Animal, Integer> {
  // public Animal findByLoginAndSenha(String nome, String senha);
  // public List<Animal> findByLoginContaining(String nome);
}
