package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vo.LoginVO;

@Controller
@RequestMapping(value = "/reportes")
public class AgregarReporteController {

	private static final Logger logger = LoggerFactory
			.getLogger(AgregarReporteController.class);

	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String MostrarLogin(HttpServletRequest resquest, Model model) {

		logger.info("--------------agregar reporte---------------------");

		

		return "reportes-add";
	}

}
