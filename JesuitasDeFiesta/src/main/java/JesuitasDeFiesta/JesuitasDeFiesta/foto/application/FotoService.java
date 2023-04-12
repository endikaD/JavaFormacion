package JesuitasDeFiesta.JesuitasDeFiesta.foto.application;

import JesuitasDeFiesta.JesuitasDeFiesta.foto.domain.Foto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface FotoService {
    public Foto subirDB(MultipartFile multipartFile, Integer idActividad) throws IOException;
}
