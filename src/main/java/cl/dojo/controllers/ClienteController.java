package cl.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.dojo.dto.ClienteDTO;
import cl.dojo.models.Cliente;
import cl.dojo.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping
	private ModelAndView clientes() {
		ModelAndView modelAndView = new ModelAndView("clientes");
		modelAndView.addObject("cliente", new Cliente());
		
		return modelAndView;
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Cliente cliente) {
		ClienteDTO respuestaServicio = clienteService.add(cliente);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/home");
		}else {
			return new RedirectView("/clientes");
		}
		
	}
		
}
