package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@RequestMapping(value = "/admUsuarios", method = RequestMethod.GET)
	public String admUsuarios(HttpServletRequest resquest, Model model) {

		logger.info("--------------Mostrando Pantalla home usuarios--------------------");

		LoginVO loginVO = new LoginVO();

		List<Usuarios> users = new ArrayList<Usuarios>();
		List<LoginVO> userList = new ArrayList<LoginVO>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from Usuarios";
			Query query = session.createQuery(queryString);
			users = (List<Usuarios>) query.list();

			for (Usuarios usuario : users) {
				LoginVO login = new LoginVO();
				login.setUserName(usuario.getUsername());
				login.setNombreCompleto(usuario.getNombreCompleto());
				login.setPerfil(usuario.getPerfil());
				login.setCelular(usuario.getCelular());
				login.setCorreoElectronico(usuario.getCorreoElectronico());
				userList.add(login);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		model.addAttribute("loginVO", loginVO);
		model.addAttribute("userList", userList);

		return "homeUsuarios";
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

	@RequestMapping(value = "/addUsuario", method = RequestMethod.GET)
	public String addUsuario(HttpServletRequest resquest, Model model) {

		logger.info("--------------Mostrando Pantalla de agregar Usuario---------------------");

		LoginVO loginVO = new LoginVO();

		model.addAttribute("loginVO", loginVO);

		return "addUser";
	}

	@RequestMapping(value = "/addUsuarioPost", method = RequestMethod.POST)
	public String addUsuarioPost(@ModelAttribute("loginVO") LoginVO loginVO,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model) {
		logger.info("Validacion de credenciales");

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Usuarios user = new Usuarios();
			trns = session.beginTransaction();

			if (loginVO != null) {
				user.setUsername(loginVO.getUserName());
				user.setPass(loginVO.getPassword());
				user.setNombreCompleto(loginVO.getNombreCompleto());
				user.setCedula(loginVO.getCedula());
				user.setPerfil(loginVO.getPerfil());
				user.setCorreoElectronico(loginVO.getCorreoElectronico());
				user.setFechaRegistro(new Date());
				user.setCelular(loginVO.getCelular());

				session.save(user);
				session.getTransaction().commit();

			}

			redirectAttributes.addFlashAttribute("mensaje",
					"Usuario agregado correctamente");
			return "redirect:/loginUsers/admUsuarios";

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			model.addAttribute("mensaje",
					"Ha ocurrido un error en la solicitud");
			return "redirect:/loginUsers/admUsuarios";
		} finally {
			session.flush();
			session.close();
		}

	}

}
