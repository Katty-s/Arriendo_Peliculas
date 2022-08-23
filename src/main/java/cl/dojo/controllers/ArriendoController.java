package cl.dojo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.dojo.dto.ArriendoDTO;
import cl.dojo.models.Arriendo;
import cl.dojo.service.IArriendoService;
import cl.dojo.service.IClienteService;
import cl.dojo.service.IPeliculaService;


@Controller
@RequestMapping("/arriendos")
public class ArriendoController {
	private static final Logger log = LoggerFactory.getLogger(ArriendoController.class);
	
	@Autowired
	private IArriendoService arriendoService;
	@Autowired
	private IPeliculaService peliculaService;
	@Autowired 
	private IClienteService clienteService;
	
	
	@GetMapping
	public ModelAndView arriendos(Model model) {
		ModelAndView modelAndView = new ModelAndView("arriendos");
		modelAndView.addObject("arriendo", new Arriendo());
		model.addAttribute("clientes", clienteService.findAll().getClientes());
		model.addAttribute("peliculas", peliculaService.findAll().getPeliculas());
		
		return modelAndView;
	}
	
	@PostMapping("/agregar")
	public RedirectView agregar(@ModelAttribute Arriendo arriendo) {
		ArriendoDTO respuestaServicio = arriendoService.add(arriendo);
		if(respuestaServicio.getCodigo().equals("0")) {
			return new RedirectView("/home");
		}else {
			return new RedirectView("/arriendos");
		}
	}

}
