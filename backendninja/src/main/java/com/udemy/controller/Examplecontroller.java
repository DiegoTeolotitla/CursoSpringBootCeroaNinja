package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example")
public class Examplecontroller {
	public static final String EXAMPLE_VIEW = "example";
	//First example
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Second example
	@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Diego A", 10));
		people.add(new Person("Diego Ar", 20));
		people.add(new Person("Diego Arm", 30));
		people.add(new Person("Diego Arma", 40));
		people.add(new Person("Diego Arman", 50));
		people.add(new Person("Diego Armand", 60));
		return people;
	}
}
