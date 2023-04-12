package JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.application.ApuntadoService;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.input.ApuntadoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/apuntado")
public class ApuntadoController {
    @Autowired
    ApuntadoService apuntadoService;

    @PostMapping
    public ApuntadoOutputDto añadirApuntado(@RequestBody ApuntadoInputDto apuntadoInputDto) throws Exception {
        return apuntadoService.añadirApuntado(apuntadoInputDto);
    }

    @GetMapping
    public List<ApuntadoOutputDto> obtenerListaApuntados(@RequestParam(defaultValue = "0", required = false) Integer pagina, @RequestParam(defaultValue = "4", required = false) Integer tamanio) {
        return apuntadoService.obtenerApuntados(pagina, tamanio);
    }

    @GetMapping("/{id}")
    public ApuntadoOutputDto obtenerApuntadoPorId(@PathVariable Integer id) throws Exception {
        return apuntadoService.obtenerApuntadoPorId(id);
    }

    @PutMapping("/{id}")
    public ApuntadoOutputDto actualizarApuntado(@PathVariable Integer id, @RequestBody ApuntadoInputDto apuntadoInputDto) throws Exception {
        return apuntadoService.actualizarApuntado(id, apuntadoInputDto);
    }

    @DeleteMapping("/{id}")
    public void borrarApuntado(@PathVariable Integer id) throws Exception {
        apuntadoService.borrarApuntado(id);
    }
}
