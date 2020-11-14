package uipa.api.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

    @Getter
    private int cod;

    @Getter
    private String descricao;

    public static Perfil toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (Perfil x : Perfil.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);

    }
}
