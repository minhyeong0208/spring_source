package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.FruitModel;

@Controller
public class FruitController {
	@Autowired
	private FruitModel fruitModel;
	
	@PostMapping("insertdata")
	public String method2(FruitBean bean, Model model) {
		model.addAttribute("data", fruitModel.computePrice(bean));
		return "list";
	}
}
