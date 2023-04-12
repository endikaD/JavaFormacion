package JesuitasDeFiesta.JesuitasDeFiesta.foto.application;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.domain.Actividad;
import JesuitasDeFiesta.JesuitasDeFiesta.actividad.repository.ActividadRepository;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.domain.Foto;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.util.Date;


@Service
public class FotoServiceImpl implements FotoService {
    @Autowired
    FotoRepository fotoRepository;
    @Autowired
    ActividadRepository actividadRepository;

    @Override
    public Foto subirDB(MultipartFile multipartFile, Integer idActividad) throws IOException {
        Foto foto = new Foto();

        foto.setTitulo(multipartFile.getOriginalFilename());
        foto.setFecha(new Date());
        foto.setType(multipartFile.getContentType());
        foto.setFileData(multipartFile.getBytes());
        foto.setActividad(actividadRepository.findById(idActividad).orElseThrow());

        return fotoRepository.save(foto);
    }

}
