package cl.dojo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SQ_PELICULA", initialValue=1, allocationSize=1)
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_PELICULA")
	private Integer id;
	private String titulo;
	private String descripcion;
	private Integer duracion;

}
