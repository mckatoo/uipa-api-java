package uipa.api.dto.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uipa.api.model.Usuario;
import uipa.api.model.enums.Perfil;

/**
 * UsuarioResponseDTO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioResponseDTO {

  private String login;
  private Set<Perfil> perfis;

  public UsuarioResponseDTO(Usuario usuario) {
    super();
    this.login = usuario.getLogin();
    this.perfis = usuario.getPerfil();
  }

}
