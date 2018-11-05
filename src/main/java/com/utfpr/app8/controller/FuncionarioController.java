package com.utfpr.app8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionarioController {

	@RequestMapping(path="/")
	public String index() {
		
		return "index";
	}
}
