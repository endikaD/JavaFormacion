package JesuitasDeFiesta.JesuitasDeFiesta.favorito.domain;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.domain.Actividad;
import JesuitasDeFiesta.JesuitasDeFiesta.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorito")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_favorito", nullable = false)
    private Integer idFavorito;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_actividad")
    private Actividad actividad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ausuario")
    private Usuario usuario;
}
