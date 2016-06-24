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
@RequestMapping(value = "/loginUsers")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/valida", method = RequestMethod.GET)
	public String MostrarLogin(HttpServletRequest resquest, Model model) {

		logger.info("--------------Mostrando Pantalla de Login---------------------");

		LoginVO loginVO = new LoginVO();

		model.addAttribute("loginVO", loginVO);

		return "login";
	}

}
