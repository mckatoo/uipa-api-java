package uipa.api.dto.response;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uipa.api.model.Usuario;
import uipa.api.utils.Security;

/**
 * UsuarioResponseDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioResponseDTO {

  private String login;

  public UsuarioResponseDTO(Usuario usuario) {
    super();
    this.login = usuario.getLogin();
  }

}
