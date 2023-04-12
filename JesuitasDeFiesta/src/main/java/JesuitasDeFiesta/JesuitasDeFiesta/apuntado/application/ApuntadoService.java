package JesuitasDeFiesta.JesuitasDeFiesta.apuntado.application;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.input.ApuntadoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;

import java.util.List;

public interface ApuntadoService {
    ApuntadoOutputDto añadirApuntado(ApuntadoInputDto apuntadoInputDto);

    ApuntadoOutputDto obtenerApuntadoPorId(Integer id);

    List<ApuntadoOutputDto> obtenerApuntados(Integer pagina, Integer tamanio);

    ApuntadoOutputDto actualizarApuntado(Integer id, ApuntadoInputDto apuntadoInputDto);

    void borrarApuntado(Integer id) throws Exception;
}
