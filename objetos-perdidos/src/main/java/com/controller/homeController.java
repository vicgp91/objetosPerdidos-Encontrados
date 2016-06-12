package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class homeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(HttpServletRequest request, Model model) {

		 model.addAttribute("hola", "Saludos desde el controlador del home ---------------Hola Mundo");
		return "index";
	}

}
