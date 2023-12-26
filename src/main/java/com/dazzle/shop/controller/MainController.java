package com.dazzle.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main.do")
	public String get_main() {
		
		return "/main/main.jsp";
	}
}
