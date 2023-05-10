package JesuitasDeFiesta.JesuitasDeFiesta.usuario.application;

import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.input.UsuarioInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output.UsuarioOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.domain.Usuario;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioOutputDto añadirUsuario(UsuarioInputDto usuarioInputDto) {
        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioInputDto.getNombre());
        usuario.setApellido(usuarioInputDto.getApellido());
        usuario.setContrasenia(usuarioInputDto.getContrasenia());
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setRol(usuarioInputDto.getRol());
        usuario.setEdad(usuarioInputDto.getEdad());
        usuario.setEtapa(usuarioInputDto.getEtapa());
        usuario.setEstado("PENDIENTE");                 //SERVICIO DE PENDIENTE A ACEPTADO(ACT)

        usuarioRepository.save(usuario);
        return new UsuarioOutputDto(usuario);
    }

    @Override
    public List<UsuarioOutputDto> obtenerUsuarios(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return usuarioRepository.findAll(pageRequest).getContent().stream().map(UsuarioOutputDto::new).toList();
    }

    @Override
    public UsuarioOutputDto obtenerUsuarioPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return new UsuarioOutputDto(usuario);
    }

//    @Override
//    public List<UsuarioOutputDto> obtenerUsuarioPorNombre(String nombre) {
//        List<UsuarioOutputDto> usuarios = new ArrayList<>();
//        for (Usuario usuario: usuarioRepository.findByNombre(nombre)) {
//            usuarios.add(new UsuarioOutputDto(usuario));
//        }
//        return usuarios;
//    }


    @Override
    public UsuarioOutputDto actualizarUsuario(Integer id, UsuarioInputDto usuarioInputDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNombre(usuarioInputDto.getNombre());
        usuario.setApellido(usuarioInputDto.getApellido());
        usuario.setContrasenia(usuarioInputDto.getContrasenia());
        usuario.setEmail(usuarioInputDto.getEmail());
        usuario.setRol(usuarioInputDto.getRol());
        usuario.setEdad(usuarioInputDto.getEdad());
        usuario.setEtapa(usuarioInputDto.getEtapa());
        usuario.setEstado(usuarioInputDto.getEstado());

        usuarioRepository.save(usuario);
        return new UsuarioOutputDto(usuario);
    }

    @Override
    public void borrarUsuario(Integer id) throws Exception {
        usuarioRepository.delete(usuarioRepository.findById(id).orElseThrow());
    }
}
