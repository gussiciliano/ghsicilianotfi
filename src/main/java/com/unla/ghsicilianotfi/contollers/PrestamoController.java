package com.unla.ghsicilianotfi.contollers;

import java.util.ArrayList;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.entities.Prestamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.ghsicilianotfi.helpers.ViewRouteHelper;
import com.unla.ghsicilianotfi.models.PersonModel;
import com.unla.ghsicilianotfi.services.IPersonService;
import com.unla.ghsicilianotfi.services.IPrestamoService;

@Controller
@RequestMapping("/prestamo")
public class PrestamoController {
	
	@Autowired
	@Qualifier("prestamoService")
	private IPrestamoService prestamoService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRESTAMO_INDEX);
		//mAV.addObject("persons", personService.getAll());
		return mAV;
	} 
	
	@GetMapping("/misprestamos")
	public ModelAndView misprestamos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRESTAMO_MIS_PRESTAMOS);
		
		mAV.addObject("elIdQueSaqueDeLaRuta", 1);
		
		List<Prestamo> prestamos = prestamoService.getAll();
		
		/*List<Prestamo> prestamos = new ArrayList<Prestamo>();
		prestamos.add(new Prestamo(123));
		prestamos.add(new Prestamo(124));
		prestamos.add(new Prestamo(125));*/
		
		mAV.addObject("id", 1);
		mAV.addObject("prestamos", prestamos);
		mAV.addObject("prestamo", new Prestamo());
		//Ir a la BD y buscar los prestamos del cliente con IDCliente = id para mandarlos a la vista
		//mAV.addObject("prestamos", prestamosDelCliente);
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("prestamo") Prestamo prestamo) {
		prestamoService.insertOrUpdate(prestamo);
		return new RedirectView(ViewRouteHelper.REDIRECT_PRESTAMO_MIS_PRESTAMOS);
	}
}
