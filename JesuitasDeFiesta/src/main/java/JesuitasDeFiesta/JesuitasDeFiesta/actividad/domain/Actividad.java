package JesuitasDeFiesta.JesuitasDeFiesta.actividad.domain;

import JesuitasDeFiesta.JesuitasDeFiesta.apuntado.domain.Apuntado;
import JesuitasDeFiesta.JesuitasDeFiesta.foto.domain.Foto;
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
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_actividad", nullable = false)
    private Integer idActividad;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "hora")
    private String hora;
    @Column(name = "etapa")
    private String etapa;
    @Column(name = "participantes")
    private Integer participantesMax;
    @OneToMany(mappedBy = "actividad", fetch = FetchType.EAGER)
    private List<Foto> fotos;
    @OneToMany(mappedBy = "actividad")
    private List<Apuntado> apuntados;
    @OneToMany(mappedBy = "actividad")
    private List<Favorito> favoritos;

}
