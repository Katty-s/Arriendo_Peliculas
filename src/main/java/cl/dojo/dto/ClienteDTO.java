package cl.dojo.dto;

import java.util.List;

import cl.dojo.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class ClienteDTO extends GenericDTO{

	private List<Cliente> clientes;
	
	public ClienteDTO(List<Cliente> clientes, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.clientes = clientes;
	}
}
