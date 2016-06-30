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
		

		LoginVO login = new LoginVO();
		login= (LoginVO) request.getSession().getAttribute("loginVO");
		model.addAttribute("loginSesion", login);
		
		 if(login != null){
			 
			 return "index";
		 }else{
			 return "redirect:/loginUsers/valida";
		 }
		 
		 
		
	}

}
