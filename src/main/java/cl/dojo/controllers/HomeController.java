package cl.dojo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.dojo.service.IArriendoService;


@Controller
public class HomeController {
	
	@Autowired
	private IArriendoService arriendoService;
	
	@GetMapping({"/","/home"})
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("arriendos", arriendoService.findAll().getArriendos());
		return modelAndView;
	}

}
