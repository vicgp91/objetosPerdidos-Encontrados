package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.HibernateUtil;
import model.Reporte;
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
import com.vo.ReporteVO;

@Controller
@RequestMapping(value = "/reportes")
public class AgregarReporteController {

	private static final Logger logger = LoggerFactory
			.getLogger(AgregarReporteController.class);

	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String MostrarLogin(HttpServletRequest resquest, Model model) {

		LoginVO loginSesion = new LoginVO();
		loginSesion = (LoginVO) resquest.getSession().getAttribute("loginVO");
		if (loginSesion == null) {
			return "redirect:/loginUsers/valida";
		}

		logger.info("--------------agregar reporte---------------------");

		ReporteVO reportevo = new ReporteVO();
		model.addAttribute("reportevo", reportevo);
		return "reportes-add";
	}

	@RequestMapping(value = "/addReportSubmit", method = RequestMethod.POST)
	public String addReportePost(
			@ModelAttribute("reportevo") ReporteVO reporteVO,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model) {
		logger.info("Validacion de credenciales");

		LoginVO loginSesion = new LoginVO();
		loginSesion = (LoginVO) request.getSession().getAttribute("loginVO");
		if (loginSesion == null) {
			return "redirect:/loginUsers/valida";
		}

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Reporte objetoreporte = new Reporte();
			trns = session.beginTransaction();

			objetoreporte.setUsuarios(new Usuarios(loginSesion.getUserName()));
			objetoreporte.setTituloReporte(reporteVO.getReportetittle());
			objetoreporte.setDescripcion(reporteVO.getDescripcion());
			objetoreporte.setCorreoContacto(loginSesion.getCorreoElectronico());
			objetoreporte.setCelularContacto(loginSesion.getCelular());
			objetoreporte.setEstadoReporte("1");
			objetoreporte.setFotoReporte("----");
			session.save(objetoreporte);
			session.getTransaction().commit();

			return "redirect:/reportes/agregar";

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			model.addAttribute("mensaje",
					"Ha ocurrido un error en la solicitud");
			return "redirect:/reportes/agregar";
		} finally {
			session.flush();
			session.close();
		}

	}

	@RequestMapping(value = "/listReportes", method = RequestMethod.GET)
	public String listReportes(HttpServletRequest resquest, Model model) {

		logger.info("--------------Mostrando Pantalla de reportes--------------------");

		LoginVO loginSesion = new LoginVO();
		loginSesion = (LoginVO) resquest.getSession().getAttribute("loginVO");
		if (loginSesion == null) {
			return "redirect:/loginUsers/valida";
		}

		LoginVO loginVO = new LoginVO();
		List<Reporte> reporte = new ArrayList<Reporte>();
		List<ReporteVO> reporteVO = new ArrayList<ReporteVO>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from Reporte";
			Query query = session.createQuery(queryString);
			reporte = (List<Reporte>) query.list();

			for (Reporte report : reporte) {
				ReporteVO rep = new ReporteVO();
				rep.setUsername(report.getUsuarios().getUsername());
				rep.setCorreo(report.getCorreoContacto());
				rep.setReporteid(report.getIdReporte());
				rep.setReportetittle(report.getTituloReporte());
				rep.setDescripcion(report.getDescripcion());
				reporteVO.add(rep);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		model.addAttribute("reporteVO", reporteVO);

		return "homeReportes";
	}

}
