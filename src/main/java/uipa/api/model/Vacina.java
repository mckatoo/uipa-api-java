package uipa.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "vacina")


public class Vacina {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codVacina;

  @Column(unique = true)
  private String nome;
  private String descricao;

  @ManyToMany(mappedBy="vacinas", cascade = CascadeType.ALL)
  private List<Animal> animais;
}
