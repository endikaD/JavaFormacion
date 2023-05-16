package JesuitasDeFiesta.JesuitasDeFiesta.usuario.domain;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.favorito.domain.Favorito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "contraseña")
    private String contrasenia;
    @Column(name = "email")
    private String email;
    @Column(name = "rol")
    private String rol;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "etapa")
    private String etapa;
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "usuario")
    private List<Apuntado> apuntados;
    @OneToMany(mappedBy = "usuario")
    private List<Favorito> favoritos;
}
