package uipa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uipa.api.model.Animal;

/**
 * AnimaisRepository
 */

public interface AnimaisRepository extends JpaRepository<Animal, Integer> {
  // public Animal findByLoginAndSenha(String nome, String senha);
  // public List<Animal> findByLoginContaining(String nome);
}
