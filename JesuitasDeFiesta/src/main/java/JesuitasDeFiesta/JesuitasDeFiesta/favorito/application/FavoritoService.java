package JesuitasDeFiesta.JesuitasDeFiesta.favorito.application;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.input.ApuntadoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.input.FavoritoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.output.FavoritoOutputDto;

import java.util.List;

public interface FavoritoService {
    FavoritoOutputDto añadirFavorito(FavoritoInputDto favoritoInputDto);

    FavoritoOutputDto obtenerFavoritoPorId(Integer id);

    List<FavoritoOutputDto> obtenerFavoritos(Integer pagina, Integer tamanio);

    FavoritoOutputDto actualizarFavorito(Integer id, FavoritoInputDto favoritoInputDto);

    void borrarFavorito(Integer id) throws Exception;
}
