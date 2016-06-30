package com.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vo.LoginVO;
import com.vo.ReporteVO;

@Controller
@RequestMapping(value = "/reportes")
public class AgregarReporteController {
	public static String ROOT = "C:" + File.separator + "" + File.separator
			+ "apache-tomcat-8.0.22" + File.separator + "webapps"
			+ File.separator + "ROOT" + File.separator + "imagenes";

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
		model.addAttribute("loginSesion", loginSesion);
		return "reportes-add";
	}

	@RequestMapping(value = "/addReportSubmit", method = RequestMethod.POST)
	public String addReportePost(
			@ModelAttribute("reportevo") ReporteVO reporteVO,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model) throws IOException {
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

			if (!reporteVO.getImg().isEmpty()) {

				Files.copy(reporteVO.getImg().getInputStream(), Paths.get(ROOT,
						reporteVO.getImg().getOriginalFilename()));
				objetoreporte.setFotoReporte(reporteVO.getImg()
						.getOriginalFilename());

			} else {
				objetoreporte.setFotoReporte("----");
			}

			trns = session.beginTransaction();

			objetoreporte.setUsuarios(new Usuarios(loginSesion.getUserName()));
			objetoreporte.setTituloReporte(reporteVO.getReportetittle());
			objetoreporte.setDescripcion(reporteVO.getDescripcion());
			objetoreporte.setCorreoContacto(loginSesion.getCorreoElectronico());
			objetoreporte.setCelularContacto(loginSesion.getCelular());
			objetoreporte.setEstadoReporte("1");
			session.save(objetoreporte);
			session.getTransaction().commit();

			return "redirect:/reportes/listReportes";

		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
			model.addAttribute("mensaje",
					"Ha ocurrido un error en la solicitud");
			return "redirect:/reportes/listReportes";
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
		
		model.addAttribute("loginSesion", loginSesion);

		LoginVO loginVO = new LoginVO();
		List<Reporte> reporte = new ArrayList<Reporte>();
		List<ReporteVO> reporteVO = new ArrayList<ReporteVO>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from Reporte order by ID_REPORTE DESC";
			Query query = session.createQuery(queryString);
			reporte = (List<Reporte>) query.list();

			for (Reporte report : reporte) {
				ReporteVO rep = new ReporteVO();
				rep.setUsername(report.getUsuarios().getUsername());
				rep.setCorreo(report.getCorreoContacto());
				rep.setReporteid(report.getIdReporte());
				rep.setReportetittle(report.getTituloReporte());
				rep.setDescripcion(report.getDescripcion());
				rep.setFoto(report.getFotoReporte());
				
				if(report.getEstadoReporte().equalsIgnoreCase("1")){
					rep.setEstado("Registrado");
				}else{
					rep.setEstado("Entregado");
				}
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

	@RequestMapping(value = "/editReporte/{id}", method = RequestMethod.GET)
	public String editar(@PathVariable("id") String id,
			final RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model) {
		logger.info("Editar Usuarios");

		LoginVO loginSesion = new LoginVO();
		loginSesion = (LoginVO) request.getSession().getAttribute("loginVO");
		if (loginSesion == null) {
			return "redirect:/loginUsers/valida";
		}

		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			Reporte rep = new Reporte();
			trns = session.beginTransaction();
			String queryString = "from Reporte where id_reporte = :id";
			Query query = session.createQuery(queryString);
			query.setString("id", id);
			rep = (Reporte) query.uniqueResult();

			if (rep != null) {

				ReporteVO repVO = new ReporteVO();
				repVO.setReporteid(rep.getIdReporte());
				repVO.setEstado(rep.getEstadoReporte());
				repVO.setReportetittle(rep.getTituloReporte());
				repVO.setDescripcion(rep.getDescripcion());
				repVO.setFoto(rep.getFotoReporte());
				
				if(rep.getEstadoReporte().equalsIgnoreCase("1")){
					repVO.setEstado("Registrado");
				}else{
					repVO.setEstado("Entregado");
				}
				
				model.addAttribute("repVO", repVO);

				return "reportes-edit";
			} else {
				return "redirect:/reportes/listReportes";
			}

		} catch (Exception e) {
			return "redirect:/reportes/listReportes";

		} finally {
			session.flush();
			session.close();
		}

	}

	@RequestMapping(value = "/editReportSubmit", method = RequestMethod.POST)
	public String submitEdit(@ModelAttribute("repVO") ReporteVO repVO,
			Model model, BindingResult result, HttpServletRequest request,
			final RedirectAttributes redirectAttributes) {

		LoginVO loginSesion = new LoginVO();
		loginSesion = (LoginVO) request.getSession().getAttribute("loginVO");
		if (loginSesion == null) {
			return "redirect:/loginUsers/valida";
		}

		logger.info("Editar report");
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Reporte rep = new Reporte();

			trns = session.beginTransaction();
			String queryString = "from Reporte where id_reporte = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", repVO.getReporteid());

			rep = (Reporte) query.uniqueResult();
			rep.setCedulaEntregado(repVO.getCedulaAquienEntrega());
			rep.setFechaEntregado(new Date());
			rep.setEstadoReporte(repVO.getEstado());

			session.update(rep);
			session.getTransaction().commit();

		} catch (Exception e) {

			logger.info("Error actualizando reporte");

			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		return "redirect:/reportes/listReportes";
	}

}
