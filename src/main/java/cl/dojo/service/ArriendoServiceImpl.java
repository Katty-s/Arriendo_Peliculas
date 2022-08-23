package cl.dojo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dojo.dto.ArriendoDTO;
import cl.dojo.dto.ClienteDTO;
import cl.dojo.models.Arriendo;
import cl.dojo.models.Cliente;
import cl.dojo.repositories.IArriendoRepository;

@Service
public class ArriendoServiceImpl implements IArriendoService{
	private static final Logger log = LoggerFactory.getLogger(ArriendoServiceImpl.class);
	
	@Autowired 
	private IArriendoRepository dao;
	private ArriendoDTO respuesta;

	@Override
	@Transactional(readOnly=true)
	public ArriendoDTO findAll() {
		respuesta = new ArriendoDTO(new ArrayList<Arriendo>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setArriendos((List<Arriendo>) dao.findAll());
			respuesta.setMensaje("Se han encontrado"+ respuesta.getArriendos().size() +"arriendos");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("ArriendoService : Error en findAll", e);
		}
		return respuesta;
		
	}

	@Override
	@Transactional
	public ArriendoDTO add(Arriendo arriendo) {
		respuesta = new ArriendoDTO(new ArrayList<Arriendo>(), "Ha ocurrido un error", "103");
		try {
			dao.save(arriendo);
			respuesta.setMensaje("Se han guardado el arriendo de la pelicula");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("ArriendoService : Error en add", e);
		}
		return respuesta;
	}

}
