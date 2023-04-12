package JesuitasDeFiesta.JesuitasDeFiesta.usuario.repository;

import JesuitasDeFiesta.JesuitasDeFiesta.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //List<Usuario> findByNombre(String nombre);
}
