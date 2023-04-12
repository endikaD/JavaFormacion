package JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output;

import JesuitasDeFiesta.JesuitasDeFiesta.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutputDto {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
    private Integer edad;
    private String etapa;
    private String estado;

    public UsuarioOutputDto (Usuario usuario){
        setIdUsuario(usuario.getIdUsuario());
        setNombre(usuario.getNombre());
        setApellido(usuario.getApellido());
        setEmail(usuario.getEmail());
        setRol(usuario.getRol());
        setEdad(usuario.getEdad());
        setEtapa(usuario.getEtapa());
        setEstado(usuario.getEstado());
    }
}
