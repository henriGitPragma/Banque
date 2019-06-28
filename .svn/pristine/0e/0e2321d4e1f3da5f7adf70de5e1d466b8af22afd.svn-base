package com.ProjetMaBanque.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	//Il va controller la vue /login
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	
	
	@RequestMapping(value="/403")
	public String AccesDenied() {
		return "403";
	}

}
