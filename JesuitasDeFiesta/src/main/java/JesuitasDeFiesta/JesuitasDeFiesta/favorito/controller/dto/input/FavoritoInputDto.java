package JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritoInputDto {
    private Integer idUsuario;
    private Integer idActividad;
}
