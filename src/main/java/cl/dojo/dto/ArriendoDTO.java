package cl.dojo.dto;

import java.util.List;

import cl.dojo.models.Arriendo;
import cl.dojo.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class ArriendoDTO extends GenericDTO{
private List<Arriendo> arriendos;
	
	public ArriendoDTO(List<Arriendo> arriendos, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.arriendos = arriendos;
	}

}
