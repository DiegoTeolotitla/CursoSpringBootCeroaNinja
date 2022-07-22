package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.constant.ViewConstant;

@Controller("contactController")
@RequestMapping("/contacts")
public class ContactController {
	
	@RequestMapping("/contactform")
	public String redirectContractForm() {
		return ViewConstant.CONTACT_FORM;
	}

}
