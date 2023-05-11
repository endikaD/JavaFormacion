package JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller;

import JesuitasDeFiesta.JesuitasDeFiesta.usuario.application.UsuarioService;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.input.UsuarioInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.controller.dto.output.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public UsuarioOutputDto añadirPersona(@RequestBody UsuarioInputDto usuarioInputDto) throws Exception {
        return usuarioService.añadirUsuario(usuarioInputDto);
    }

    @GetMapping
    public List<UsuarioOutputDto> obtenerListaPersonas(@RequestParam(defaultValue = "0", required = false) Integer pagina,
                                                       @RequestParam(defaultValue = "4", required = false) Integer tamanio) {
        return usuarioService.obtenerUsuarios(pagina, tamanio);
    }

    @GetMapping("/{id}")
    public UsuarioOutputDto obtenerPersonaPorId(@PathVariable Integer id) throws Exception {
        return usuarioService.obtenerUsuarioPorId(id);
    }

//    @GetMapping("/nombre/{usuario}")
//    public List<UsuarioOutputDto> obtenerPersonaPorNombre(@PathVariable String nombre) {
//        return usuarioService.obtenerUsuarioPorNombre(nombre);
//    }

    @PutMapping("/{id}")
    public UsuarioOutputDto actualizarPersona(@PathVariable Integer id, @RequestBody UsuarioInputDto usuarioInputDto) throws Exception {
        return usuarioService.actualizarUsuario(id, usuarioInputDto);
    }

    @DeleteMapping("/{id}")
    public void borrarPersona(@PathVariable Integer id) throws Exception {
        usuarioService.borrarUsuario(id);
    }
}
