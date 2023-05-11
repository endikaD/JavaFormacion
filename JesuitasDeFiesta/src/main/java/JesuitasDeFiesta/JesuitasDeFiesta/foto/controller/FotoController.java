package JesuitasDeFiesta.JesuitasDeFiesta.foto.controller;

import JesuitasDeFiesta.JesuitasDeFiesta.foto.application.FotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foto")
@CrossOrigin(origins = "*")
public class FotoController {
    @Autowired
    private FotoService fotoService;
    @PostMapping("/{idActividad}")
    public ResponseEntity<String> subirDB(@RequestParam("files")MultipartFile multipartFile, @PathVariable Integer idActividad) throws Exception {
        fotoService.subirDB(multipartFile, idActividad);
        return ResponseEntity.status(HttpStatus.OK).body("Archivos subidos");
    }
}
