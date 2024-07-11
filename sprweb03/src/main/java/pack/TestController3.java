package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController3 {
	
	@RequestMapping("/java/korea")
	public String responseTest10_1(Model model) {
		model.addAttribute("msg", "/java/korea 요청 성공!");
		return "list";
	}
	
	@GetMapping(value = {"/java/japan", "china", "russia"})  // 여러 개의 요청을 배열 형태로 지정.
	public String responseTest10_2(Model model) {
		model.addAttribute("msg", "여러 개의 요청이 하나의 메소드와 매핑!");
		return "list";
	}
	
}
