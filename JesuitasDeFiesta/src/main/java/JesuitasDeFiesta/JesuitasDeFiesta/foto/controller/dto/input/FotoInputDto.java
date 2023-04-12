package JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FotoInputDto {
    private String titulo;
    private String descripcion;
    private String fecha;
    private Integer idActividad;
}
