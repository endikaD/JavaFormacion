package JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.controller.dto.output.ActividadOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output.UsuarioOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApuntadoOutputDto {
    private Integer idApuntado;
    private UsuarioOutputDto usuarioOutputDto;
    private ActividadOutputDto actividadOutputDto;
    public ApuntadoOutputDto (Apuntado apuntado){
        setIdApuntado(apuntado.getIdApuntado());
        setUsuarioOutputDto(new UsuarioOutputDto(apuntado.getUsuario()));
        setActividadOutputDto(new ActividadOutputDto(apuntado.getActividad()));
    }
}
