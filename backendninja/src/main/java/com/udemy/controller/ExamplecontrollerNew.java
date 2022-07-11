package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class ExamplecontrollerNew {
	public static final String EXAMPLE_VIEW_TWO = "exampletwo";
	
	@GetMapping("/requestone")
	public ModelAndView requestOne(@RequestParam(name = "nm", required = false, defaultValue = "Amigo") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_TWO);
		mav.addObject("nm_in_model", name);
		return mav;
	}

	@GetMapping("/requesttwo/{nm}")
	public ModelAndView requestTwo(@PathVariable("nm")String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_TWO);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
}
