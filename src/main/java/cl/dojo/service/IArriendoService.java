package cl.dojo.service;

import cl.dojo.dto.ArriendoDTO;
import cl.dojo.models.Arriendo;

public interface IArriendoService {
	
	ArriendoDTO findAll();
	ArriendoDTO add(Arriendo arriendo);

}
