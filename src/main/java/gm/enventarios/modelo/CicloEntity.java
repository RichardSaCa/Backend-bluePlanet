package gm.enventarios.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CicloEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Integer id;
    Integer orden;
    String longitud;
    String latitud;
    String descripcion;
    String datoInteresante;
    String nombre;
    String imagen;
    String enlace;
}
