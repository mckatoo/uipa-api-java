package uipa.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uipa.api.model.Usuario;

/**
 * UsuarioResponseDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioResponseDTO {

  private String login;
  private String senha;
  private String biometria;

  public UsuarioResponseDTO(Usuario usuario) {
    super();
    this.login = usuario.getLogin();
  }

}
