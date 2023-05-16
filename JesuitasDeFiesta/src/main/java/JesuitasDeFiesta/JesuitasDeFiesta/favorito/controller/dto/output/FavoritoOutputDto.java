package JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.output;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.controller.dto.output.ActividadOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.domain.Favorito;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output.UsuarioOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritoOutputDto {
    private Integer idFavorito;
    private UsuarioOutputDto usuarioOutputDto;
    private ActividadOutputDto actividadOutputDto;
    public FavoritoOutputDto(Favorito favorito){
        setIdFavorito(favorito.getIdFavorito());
        setUsuarioOutputDto(new UsuarioOutputDto(favorito.getUsuario()));
        setActividadOutputDto(new ActividadOutputDto(favorito.getActividad()));
    }
}
