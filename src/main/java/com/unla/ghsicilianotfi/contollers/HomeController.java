package com.unla.ghsicilianotfi.contollers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.ghsicilianotfi.helpers.ViewRouteHelper;
import com.unla.ghsicilianotfi.models.DegreeModel;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/degree")
	public String degree(Model model) {
		model.addAttribute("degree", new DegreeModel());
		return ViewRouteHelper.DEGREE;
	}
	
	@PostMapping("/newdegree")
	public ModelAndView newdegree(@Valid @ModelAttribute("degree") DegreeModel degree, BindingResult bindingResult) {
		ModelAndView mV = new ModelAndView();
		if (bindingResult.hasErrors()) {
			mV.setViewName(ViewRouteHelper.DEGREE);
		} else {
			mV.setViewName(ViewRouteHelper.NEW_DEGREE);
			mV.addObject("degree", degree);
		}
		return mV;
	}
	
	//GET Example: SERVER/index
	@GetMapping("/index")
	public String index() {
		return ViewRouteHelper.INDEX;
	}
	
	//GET Example: SERVER/hello?name=someName
	@GetMapping("/hello")
	public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}
	
	//GET Example: SERVER/hello/someName
	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
		mV.addObject("name", name);
		return mV;
	}
	
	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}
}

