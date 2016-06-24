package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vo.LoginVO;


@Controller
public class homeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicio(HttpServletRequest request, Model model) {
		
		
		//RegistroCivilVO regCivil = (RegistroCivilVO) request.getSession().getAttribute("regCivil");
		
		
		LoginVO login = new LoginVO();
		
		
		login= (LoginVO) request.getSession().getAttribute("loginVO");

		 model.addAttribute("hola", "Saludos desde el controlador del home ---------------Hola Mundo");
		 
		 
		 if(login.getUserName()!=null){
			 return "index";
		 }else{
			 return "redirect:/loginUsers/valida";
		 }
		 
		 
		
	}

}
