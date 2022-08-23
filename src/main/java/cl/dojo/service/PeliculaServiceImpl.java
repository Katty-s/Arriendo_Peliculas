package cl.dojo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dojo.dto.ArriendoDTO;
import cl.dojo.dto.PeliculaDTO;
import cl.dojo.models.Arriendo;
import cl.dojo.models.Pelicula;
import cl.dojo.repositories.IArriendoRepository;
import cl.dojo.repositories.IPeliculaRepository;

@Service
public class PeliculaServiceImpl  implements IPeliculaService{
	private static final Logger log = LoggerFactory.getLogger(PeliculaServiceImpl.class);

	@Autowired 
	private IPeliculaRepository dao;
	private PeliculaDTO respuesta;
	
	@Override
	@Transactional(readOnly=true)
	public PeliculaDTO findAll() {
		respuesta = new PeliculaDTO(new ArrayList<Pelicula>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setPeliculas((List<Pelicula>) dao.findAll());
			respuesta.setMensaje("Se han encontrado"+ respuesta.getPeliculas().size() +"peliculas");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("PeliculasService : Error en findAll", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public PeliculaDTO add(Pelicula pelicula) {
		respuesta = new PeliculaDTO(new ArrayList<Pelicula>(), "Ha ocurrido un error", "103");
		try {
			dao.save(pelicula);
			respuesta.setMensaje("Se ha guardado correctamente el cliente"+ respuesta.getPeliculas().size() +"arriendos");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("ArriendoService : Error en add", e);
		}
		return respuesta;
	}
	

}
