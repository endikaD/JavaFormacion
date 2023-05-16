package JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInputDto {
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String email;
    private String rol;
    private Integer edad;
    private String etapa;
    private String estado;
}
