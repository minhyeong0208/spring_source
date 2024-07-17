package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/*
// 현재 뷰 파일을 사용하지 않음. 문자열을 @RestController가 리턴했다.
@RestController // 리턴값을 json이나 xml로 해준다. 여기서는 return 값을 문자열로 설정했으므로 사용?, ajax를 사용할 때 사용하는 어노테이션
public class TestController {
	// dispatcher 
	@RequestMapping("test1")  // test1에 대한 요청이 들어오면 메소드 실행, get/post 구분을 하지 않음.
	public String responseTest() {  
		return "요청에 대한 반응 보이기";
	}
}
*/

@Controller  // 사용자의 요청을 처리한 후, 지정된 View(템플릿 엔진 : jsp ...)에 Model 객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1")  // get, post 방식 모두 처리 가능
	public ModelAndView responseTest() {  
//		System.out.println("responseTest 메소드 처리");
//		return null;
		
		// 오리지널 방식
//		return new ModelAndView("list", "msg", "안녕? jsp");  // 첫번째 인자는 view 파일명 : list.jsp를 찾도록 함.
		
		// 위 return을 풀어 적으면 다음과 같다.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "안녕? jsp");
		// HttpServletRequest를 사용해 키, 값으로 JSP에 전송
		modelAndView.addObject("msg", "안녕? jsp"); 
		return modelAndView;
	}
	
	// 디스패처 서블릿으로부터 위임받은 핸들러 매핑이 @RequestMapping을 찾아감.
	@RequestMapping(value="test2", method=RequestMethod.GET)  // get 요청 처리
	public ModelAndView responseTest2() {
		return new ModelAndView("list", "msg", "성공!");
	}
	
	@GetMapping("test3")  // get 요청 처리
	public ModelAndView responseTest3() {
		return new ModelAndView("list", "msg", "@GetMapping 성공!");
	}
	
	@GetMapping("test4")  // get 요청 처리
	public String responseTest4(Model model) {
		model.addAttribute("msg", "매개변수로 Model을 전달 성공!");  // 모델에 삽입
		return "list";  // 파일명 반환
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST)  // post 요청 처리
	public ModelAndView responseTest5() {
		return new ModelAndView("list", "msg", "성공5!");
	}
	
	@PostMapping("test6")  // post 요청 처리
	public String responseTest6(ModelMap modelMap) {
		modelMap.addAttribute("message", "Hello, World!");
		modelMap.put("username", "john_doe");
        modelMap.put("age", 30);
        modelMap.put("email", "john.doe@example.com");
        
        // 키-값 쌍 삭제
        modelMap.remove("email");
		return "list";
	}
	
	@PostMapping("test7")  // post 요청 처리
	public String responseTest7(Model model) {  // 매개변수에 Model 타입이 존재하면, view 파일명을 반환, String을 반환하는 것이 아님.
		model.addAttribute("msg", "매개변수로 Model을 전달 성공!");  // 모델에 삽입
		return "list";
	}
	
	@GetMapping("test8")  // get 요청 처리
	@ResponseBody  // 일반 데이터를 그대로 리턴한다.
	public String responseTest8() {
		String value = "일반 데이터-String, Map, JSON 등을 전달 가능";
		return value;
	}
	
	@GetMapping("test8_1")  // get 요청 처리
	@ResponseBody  // JSON 타입으로 반환한다. 참고 : jackson 라이브러리 지원
	public DataDto responseTest8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("하이");
		return dto;  
	}
}