package cl.dojo.service;

import cl.dojo.dto.ClienteDTO;
import cl.dojo.models.Cliente;

public interface IClienteService {

	ClienteDTO findAll();
	ClienteDTO add(Cliente cliente);
}
