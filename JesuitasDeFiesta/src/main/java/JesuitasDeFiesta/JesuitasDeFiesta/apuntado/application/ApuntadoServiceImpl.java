package JesuitasDeFiesta.JesuitasDeFiesta.apuntado.application;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.repository.ActividadRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.input.ApuntadoInputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.controller.dto.output.ApuntadoOutputDto;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.repository.ApuntadoRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApuntadoServiceImpl implements ApuntadoService{
    @Autowired
    ApuntadoRepository apuntadoRepository;
    @Autowired
    ActividadRepository actividadRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public ApuntadoOutputDto añadirApuntado(ApuntadoInputDto apuntadoInputDto) {
        Apuntado apuntado = new Apuntado();

        apuntado.setUsuario(usuarioRepository.findById(apuntadoInputDto.getIdUsuario()).orElseThrow());
        apuntado.setActividad(actividadRepository.findById(apuntadoInputDto.getIdActividad()).orElseThrow());

        apuntadoRepository.save(apuntado);
        return new ApuntadoOutputDto(apuntado);
    }

    @Override
    public ApuntadoOutputDto obtenerApuntadoPorId(Integer id) {
        Apuntado apuntado = apuntadoRepository.findById(id).orElseThrow();
        return new ApuntadoOutputDto(apuntado);
    }

    @Override
    public List<ApuntadoOutputDto> obtenerApuntados(Integer pagina, Integer tamanio) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanio);
        return apuntadoRepository.findAll(pageRequest).getContent().stream().map(ApuntadoOutputDto::new).toList();
    }

    @Override
    public ApuntadoOutputDto actualizarApuntado(Integer id, ApuntadoInputDto apuntadoInputDto) {
        Apuntado apuntado = apuntadoRepository.findById(id).orElseThrow();

        apuntado.setUsuario(usuarioRepository.findById(apuntadoInputDto.getIdUsuario()).orElseThrow());
        apuntado.setActividad(actividadRepository.findById(apuntadoInputDto.getIdActividad()).orElseThrow());

        apuntadoRepository.save(apuntado);
        return new ApuntadoOutputDto(apuntado);
    }

    @Override
    public void borrarApuntado(Integer id) throws Exception {
        apuntadoRepository.delete(apuntadoRepository.findById(id).orElseThrow());
    }
}
