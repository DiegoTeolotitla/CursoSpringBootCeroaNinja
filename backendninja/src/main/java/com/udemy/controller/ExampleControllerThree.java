package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/examplethree")
public class ExampleControllerThree {

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	public static final Log LOGGER = LogFactory.getLog(ExampleControllerThree.class);
	
	//First Example redirect
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/examplethree/showform";
	}*/
	//Second Example redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/examplethree/showform");
	}
	
	
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: " + person.toString());
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			LOGGER.info("TIENE ERRORES");
			mav.setViewName(FORM_VIEW);
		}else {
			LOGGER.info("NO TIENE ERRORES");
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		
		return mav;
	}
}
