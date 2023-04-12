package JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain;

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
@Table(name = "apuntado")
public class Apuntado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_apuntado", nullable = false)
    private Integer idApuntado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_actividad")
    private Actividad actividad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ausuario")
    private Usuario usuario;
}
