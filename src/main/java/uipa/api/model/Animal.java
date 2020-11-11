package uipa.api.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

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

  @ManyToOne
  private Adotante adotante;
  
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name="vacinado",
             joinColumns={@JoinColumn(name="CodVacina")},
             inverseJoinColumns={@JoinColumn(name="CodAnimal")})
  private List<Vacina> vacinas;
}
