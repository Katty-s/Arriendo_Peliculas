package cl.dojo.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.dojo.dto.ClienteDTO;
import cl.dojo.models.Cliente;
import cl.dojo.repositories.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private IClienteRepository dao;
	private ClienteDTO respuesta;
	
	@Override
	@Transactional(readOnly=true)
	public ClienteDTO findAll() {
		respuesta = new ClienteDTO(new ArrayList<Cliente>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setClientes((List<Cliente>) dao.findAll());
			respuesta.setMensaje("Se han encontrado"+ respuesta.getClientes().size() +"clientes");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("ClienteService : Error en findAll", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ClienteDTO add(Cliente cliente) {
		respuesta = new ClienteDTO(new ArrayList<Cliente>(), "Ha ocurrido un error", "103");
		try {
			dao.save(cliente);
			respuesta.setMensaje("Se han encontrado"+ respuesta.getClientes().size() +"clientes");
			respuesta.setCodigo("0");
		}catch(Exception e) {
			log.trace("ClienteService : Error en add", e);
		}
		return respuesta;
		
		
	}

}
