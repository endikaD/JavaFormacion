package JesuitasDeFiesta.JesuitasDeFiesta.usuario.application;

import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.input.UsuarioInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output.UsuarioOutputDto;

import java.util.List;

public interface UsuarioService {
    UsuarioOutputDto añadirUsuario(UsuarioInputDto usuarioInputDto);

    //List<UsuarioOutputDto> obtenerUsuarioPorNombre(String nombre);

    UsuarioOutputDto obtenerUsuarioPorId(Integer id);

    List<UsuarioOutputDto> obtenerUsuarios(Integer pagina, Integer tamanio);

    UsuarioOutputDto actualizarUsuario(Integer id, UsuarioInputDto usuarioInputDto);

    void borrarUsuario(Integer id) throws Exception;
}
