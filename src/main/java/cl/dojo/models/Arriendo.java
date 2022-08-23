package cl.dojo.models;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SQ_ARRIENDO", initialValue=1, allocationSize=1)

public class Arriendo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_ARRIENDO")
    private Integer id;
	private String inicio;
	private Integer duracion;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="pelicula_id", referencedColumnName="id")
    private Pelicula pelicula;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id")
	private Cliente cliente;

}
