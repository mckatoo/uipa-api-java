package uipa.api.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Animais
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "animal")

public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codAnimal;
  private String nome;
  private String especie;
  private Character[] sexo;
  private Timestamp dataNasc;
  private Character[] porte;
  private Character[] castrado;
  private Integer codAdotante;
  private Timestamp dataAdocao;

}
