package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FromController {
	
	@PostMapping("/nameage")
	public String method(@RequestParam("name")String name, @RequestParam("age")int age, Model model) {
		String gener;
		if(age >= 10 && age <=19) gener = "십대";
		else if(age >= 20 && age <=29) gener = "이십대";
		else if(age >= 30 && age <=39) gener = "삼십대";
		else gener = "사십대 이상";
		
		model.addAttribute("name", name);
		model.addAttribute("age", gener);
		return "result";
	}
}
