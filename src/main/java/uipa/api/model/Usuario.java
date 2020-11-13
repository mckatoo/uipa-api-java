package uipa.api.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import uipa.api.utils.Security;

/**
 * Usuario
 */

@Data
@Accessors(chain = true)
@NoArgsConstructor
@ToString()
@EqualsAndHashCode()
@Entity(name = "usuario")

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codUsuario;

  @Column(unique = true)
  private String login;

  private String senha;

  private String biometria;

  public Usuario setSenha(String senha) {
    try {
      this.senha = new Security().criptografar(senha);
    } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }
  
}
