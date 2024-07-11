package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9") // 공통 속성은 밖으로 빼낼 수 있다.
public class TestController2 {
	
	@RequestMapping(method=RequestMethod.GET)
	public String responseTest9(Model model) {
		// Model의 역할 : HttpServletRequest 객체의 값을 저장 후, 뷰에 전달
		model.addAttribute("msg", "Success GET");
		return "list";  // redirect X, forward O -> 스프링은 forward가 기본.
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String responseTest9_2(Model model) {
		model.addAttribute("msg", "Success POST");
		return "list";
	}
}
