package pack.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "thleaf")
public class TestController {
	
	@GetMapping("/ex1")
	public String method1(Model model) {
		ItemDto dto  = new ItemDto();
		dto.setId("ks0"); dto.setName("마우스"); 
		dto.setPrice(5000); dto.setRegDate(LocalDate.now());
		model.addAttribute("dto", dto);
		
		return "show1";
	}
	
	@GetMapping("/ex2")
	public ModelAndView method2() {
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i = 1; i <= 3; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i); dto.setName("신상품" + i); 
			dto.setPrice(1000 * i); dto.setRegDate(LocalDate.now());
			list.add(dto);
		}
		
		ModelAndView modelAndView = new ModelAndView("show2");
		modelAndView.addObject("dtos", list);
		
		return modelAndView;
	}
	
	@GetMapping("/ex3")
	public String method3(Model model) {
		List<ItemDto> list = new ArrayList<ItemDto>();
		
		for(int i = 1; i <= 5; i++) {
			ItemDto dto = new ItemDto();
			dto.setId("ks" + i); dto.setName("신상품" + i); 
			list.add(dto);
		}
		
		model.addAttribute("dtos", list);
		
		return "show3";
	}
	
	@GetMapping("/ex4")
	public String method4(Model model, @RequestParam("param1")String param1, @RequestParam(value = "param2")String param2) {
		System.out.println(param1 + " " + param2);
		
		model.addAttribute("arg1", param1);
		model.addAttribute("arg2", param2);
		return "show4";
	}
	
	// 레이아웃
	@GetMapping("/ex5")
	public String method5() {
		
		return "show5";
	}
	
}