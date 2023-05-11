package JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.application.ApuntadoService;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.input.ApuntadoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.application.FavoritoService;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.input.FavoritoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.output.FavoritoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorito")
@CrossOrigin(origins = "*")
public class FavoritoController {
    @Autowired
    FavoritoService favoritoService;

    @PostMapping
    public FavoritoOutputDto añadirFavorito(@RequestBody FavoritoInputDto favoritoInputDto) throws Exception {
        return favoritoService.añadirFavorito(favoritoInputDto);
    }

    @GetMapping
    public List<FavoritoOutputDto> obtenerListaFavoritos(@RequestParam(defaultValue = "0", required = false) Integer pagina, @RequestParam(defaultValue = "4", required = false) Integer tamanio) {
        return favoritoService.obtenerFavoritos(pagina, tamanio);
    }

    @GetMapping("/{id}")
    public FavoritoOutputDto obtenerFavoritoPorId(@PathVariable Integer id) throws Exception {
        return favoritoService.obtenerFavoritoPorId(id);
    }

    @PutMapping("/{id}")
    public FavoritoOutputDto actualizarFavorito(@PathVariable Integer id, @RequestBody FavoritoInputDto favoritoInputDto) throws Exception {
        return favoritoService.actualizarFavorito(id, favoritoInputDto);
    }

    @DeleteMapping("/{id}")
    public void borrarFavorito(@PathVariable Integer id) throws Exception {
        favoritoService.borrarFavorito(id);
    }
}
