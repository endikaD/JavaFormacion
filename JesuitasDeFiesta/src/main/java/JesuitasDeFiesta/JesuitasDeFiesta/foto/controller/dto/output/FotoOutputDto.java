package JesuitasDeFiesta.JesuitasDeFiesta.foto.controller.dto.output;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.controller.dto.output.ActividadOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.domain.Foto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FotoOutputDto {
    private Integer idFoto;
    private String titulo;
    private String descripcion;
    private String fecha;
    private ActividadOutputDto actividadOutputDto;

    public FotoOutputDto(Foto foto) {
        setIdFoto(foto.getIdFoto());
        setTitulo(foto.getTitulo());
        setDescripcion(foto.getD());
        setFecha(foto.getFecha());
        setActividadOutputDto(new ActividadOutputDto(foto.getActividad()));
    }
}
