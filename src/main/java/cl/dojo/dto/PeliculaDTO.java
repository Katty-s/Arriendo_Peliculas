package cl.dojo.dto;

import java.util.List;

import cl.dojo.models.Cliente;
import cl.dojo.models.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class PeliculaDTO extends GenericDTO{
	
private List<Pelicula> peliculas;
	
	public PeliculaDTO(List<Pelicula> peliculas, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.peliculas = peliculas;
	}
}
