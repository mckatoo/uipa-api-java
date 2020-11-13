package uipa.api.dto.request;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uipa.api.model.Usuario;

/**
 * UsuarioRequestDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequestDTO {

  private String login;
  private String senha;
  private String biometria;

  public Usuario build() throws NoSuchAlgorithmException, UnsupportedEncodingException {
    Usuario usuario = new Usuario()
      .setLogin(this.login)
      .setSenha(this.senha)
      .setBiometria(this.biometria);
    return usuario;
  }

}
