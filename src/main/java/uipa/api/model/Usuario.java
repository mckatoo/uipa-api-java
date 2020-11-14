package uipa.api.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import uipa.api.model.enums.Perfil;
import uipa.api.utils.Security;

/**
 * Usuario
 */

@Data
@Accessors(chain = true)
@ToString()
@EqualsAndHashCode()
@Entity(name = "usuario")

public class Usuario {

  public Usuario() {
    addPerfil(Perfil.CLIENTE);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codUsuario;

  @Column(unique = true)
  private String login;

  private String senha;

  private String biometria;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "perfis")
  private Set<Integer> perfis = new HashSet<>();

  public Set<Perfil> getPerfil() {
    return perfis.stream().map(p -> Perfil.toEnum(p)).collect(Collectors.toSet());
  }

  public void addPerfil(Perfil perfil) {
    perfis.add(perfil.getCod());
  }

  public Usuario setSenha(String senha) {
    try {
      this.senha = new Security().criptografar(senha);
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

}
