package com.eval.coronakit.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping("/custom-login")
	public String login() {
		String view ="login-form";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.err.println(auth.getAuthorities());
		if(!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {			
			view ="redirect:/home";
		}
		return view;
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
}
