package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String start(Model model) {
		model.addAttribute("msg", "타임리프 🎶");
		model.addAttribute("msg2", "유로 2024 🎶🎶");
		
		// DTO 자료 출력용
		Product product = new Product();
		product.setCode("10"); product.setName("삼다수"); product.setPrice("1000");
		model.addAttribute("product", product);
		
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(product);
		
		product = new Product();
		product.setCode("20"); product.setName("아메리카노"); product.setPrice("1500");
		list.add(product);
		
		model.addAttribute("list", list);  // 컬렉션 리턴
		
		return "list1";  // forwarding -> 자동으로 templates(prefix) 디렉토리로 이동. 확장자(suffix)는 html을 기본값으로 가진다.
	}
	
	@PostMapping("nameage")
	public String method(@RequestParam("name")String name, @RequestParam("age")int age, Model model) {
		String gener;
		if(age >= 10 && age <=19) gener = "십대";
		else if(age >= 20 && age <=29) gener = "이십대";
		else if(age >= 30 && age <=39) gener = "삼십대";
		else gener = "사십대 이상";
		
		model.addAttribute("name", name);
		model.addAttribute("age", gener);
		return "show";
	}
}
