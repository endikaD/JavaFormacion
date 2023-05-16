package JesuitasDeFiesta.JesuitasDeFiesta.favorito.application;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.repository.ActividadRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.input.FavoritoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.controller.dto.output.FavoritoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.domain.Favorito;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.repository.FavoritoRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoritoServiceImpl implements FavoritoService{
    @Autowired
    FavoritoRepository favoritoRepository;
    @Autowired
    ActividadRepository actividadRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public FavoritoOutputDto añadirFavorito(FavoritoInputDto favoritoInputDto) {
        Favorito favorito = new Favorito();

        favorito.setUsuario(usuarioRepository.findById(favoritoInputDto.getIdUsuario()).orElseThrow());
        favorito.setActividad(actividadRepository.findById(favoritoInputDto.getIdActividad()).orElseThrow());

        favoritoRepository.save(favorito);
        return new FavoritoOutputDto(favorito);
    }

    @Override
    public FavoritoOutputDto obtenerFavoritoPorId(Integer id) {
        Favorito favorito = favoritoRepository.findById(id).orElseThrow();
        return new FavoritoOutputDto(favorito);
    }

    @Override
    public List<FavoritoOutputDto> obtenerFavoritos(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return favoritoRepository.findAll(pageRequest).getContent().stream().map(FavoritoOutputDto::new).toList();
    }

    @Override
    public FavoritoOutputDto actualizarFavorito(Integer id, FavoritoInputDto favoritoInputDto) {
        Favorito favorito = favoritoRepository.findById(id).orElseThrow();

        favorito.setUsuario(usuarioRepository.findById(favoritoInputDto.getIdUsuario()).orElseThrow());
        favorito.setActividad(actividadRepository.findById(favoritoInputDto.getIdActividad()).orElseThrow());

        favoritoRepository.save(favorito);
        return new FavoritoOutputDto(favorito);
    }

    @Override
    public void borrarFavorito(Integer id) throws Exception {
        favoritoRepository.delete(favoritoRepository.findById(id).orElseThrow());
    }
}
