package com.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.HibernateUtil;
import model.Usuarios;

import org.hibernate.Query;
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
		// model.addAttribute("ocultarmensaje", true);
		// model.addAttribute("mensajeLogin", "noMostrar");

		return "login";
	}

	@RequestMapping(value = "/validaSubmit", method = RequestMethod.POST)
	public String editar(@ModelAttribute("loginVO") LoginVO loginVO,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model) {
		logger.info("Validacion de credenciales");

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Usuarios user = new Usuarios();
			trns = session.beginTransaction();
			String queryString = "from Usuarios where USERNAME = :id";
			Query query = session.createQuery(queryString);
			query.setString("id", loginVO.getUserName());
			user = (Usuarios) query.uniqueResult();

			if (user != null) {

				if (user.getPass().equalsIgnoreCase(loginVO.getPassword())) {

					request.getSession().setAttribute("loginVO", loginVO);

					return "redirect:/";

				} else {
					redirectAttributes.addFlashAttribute("mensajeLogin",
							"Error credenciales incorrectas");
					return "redirect:/loginUsers/valida";
				}

			} else {
				redirectAttributes.addFlashAttribute("mensajeLogin",
						"Usuario no existe");
				return "redirect:/loginUsers/valida";
			}
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			model.addAttribute("mensajeLogin",
					"Ha ocurrido un error al intentar validar su informacion");
			return "redirect:/loginUsers/valida";
		} finally {
			session.flush();
			session.close();
		}

	}

}
