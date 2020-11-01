package uipa.api.dto.request;

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

  public Usuario build() {
    Usuario usuario = new Usuario()
      .setLogin(this.login)
      .setSenha(this.senha)
      .setBiometria(this.biometria);
    return usuario;
  }

}
