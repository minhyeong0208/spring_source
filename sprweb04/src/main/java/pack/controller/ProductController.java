package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ProductModel;

@Controller
public class ProductController {
	
	@Autowired
	private ProductModel productModel;
	
	@GetMapping("insertdata")
	public String method1() {
		return "redirect:input.html";
	}
	
	@PostMapping("insertdata")
	public String method2(ProductBean bean, Model model) {
		model.addAttribute("data", productModel.computePrice(bean));
		return "result";
	}
}
