package com.wizta.springphonebook.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
	
	  @RequestMapping("/")
	    String home() {
	        return "index";
	    }

}
