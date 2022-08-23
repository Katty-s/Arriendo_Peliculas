package cl.dojo.service;

import cl.dojo.dto.PeliculaDTO;
import cl.dojo.models.Pelicula;

public interface IPeliculaService {
	
	PeliculaDTO findAll();
	PeliculaDTO add(Pelicula pelicula);

}
