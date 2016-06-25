package com.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.HibernateUtil;
import model.Usuarios;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	
	
	
	@RequestMapping(value = "/validaSubmit", method = RequestMethod.POST)
	public String editar(@ModelAttribute("loginVO") LoginVO loginVO,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model)  {
		logger.info("Validacion de credenciales");

		
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       
        try {
        	
        	Usuarios user = new Usuarios();
        	user.setUsername(loginVO.getUserName());
        	user.setPass(loginVO.getPassword());
        	user.setCorreoElectronico("hhh");
        	user.setPerfil("1");
        	user.setNombreCompleto("nnn");
        	user.setUltimoIngreso(new Date());
        	
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
		
		
		
		
		
		
		
		
		

		request.getSession().setAttribute("loginVO", loginVO);

		return "redirect:/";
	}

	
	
	

}
