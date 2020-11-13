package uipa.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Adotante
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString()
@EqualsAndHashCode()
@Entity(name = "adotante")

public class Adotante {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codAdotante;
  private String nome;
  private Integer telefone;
  private String celular;
  private String cep;
  private String endereco;
  private String bairro;
  private String cidade;
  private String uf;
  private String cpf;
  private String rg;
  private Character[] sexo;
  private String email;

  @OneToMany
  private List<Animal> animais;

}
