package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/examplefour")
public class ExampleControllerFour {
	
	public static final String ERROR_VIEW = "404";
	
	@GetMapping("/error")
	public ModelAndView errorPage() {
		ModelAndView mav = new ModelAndView(ERROR_VIEW);
		int result = 6/0;
		return mav;
	}

}
