package com.wizta.springphonebook.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	
	@RequestMapping("/")
	String home() {
		return "index";
	}
	

}
