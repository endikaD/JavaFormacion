package JesuitasDeFiesta.JesuitasDeFiesta.foto.domain;

import JesuitasDeFiesta.JesuitasDeFiesta.actividad.domain.Actividad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFoto; //get
    private String titulo; //get
    private Date fecha;
    private String type;
    @Lob
    private byte[] fileData;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_actividad")
    private Actividad actividad;
}
