package pack.controller;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

// @Component : 객체만 선언됨.
@Controller // 클라이언트의 요청을 받아 모델을 다녀와서 뷰로 전달.
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitCall() {  // 매개변수로 Model 사용 불가 그 이유?

//		return "login.html"  // forward : 기본 값
//		return "redirect:login.html";  // redirect 명시적으로 작성해야함.
		return "redirect:http://localhost/login.html";  // 위 행과 동일, html의 경우, 쿼리 스트링 전달 불가
		// JSP를 사용한 경우, webapp로 이동, 이는 application.properties에 정의했다.
		// 타임리프를 사용하면 templates 디렉토리로 이동
	}
/*	
	// 클라이언트가 전달한 값 수신 방법 1 : 전통적인 방법
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) {  // 반환형이 ModelAndView라면 매개변수로 Model 타입을 전달할 필요가 없음!
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 초보적인 방식
		System.out.println(id + " " + pwd);
		// Logger 클래스 사용
		logger.info(id + " " + pwd);  // 로그 레벨 : trace > debug > info > warn > error > fatal
		
		
		String data = "";
		if(id.equals("user") && pwd.equals("user")) {
			data = "로그인 성공";
		} else { 
			data = "로그인 실패";
		}
		
		model.addAttribute("data", data); // setAttribute()의 역할.
		return "result";  // forwarding
	}
*/	
	
	
	// 클라이언트가 입력한 값은 항상 문자열로 넘어옴.
	
	
	// 클라이언트가 전달한 값 수신 방법 2 : Spring Annotation 사용
	@PostMapping("login")
	public String submit(@RequestParam(value = "id")String id, // id는 login.html의 input 태그 name 속성 "id"를 가리킴
					   //@RequestParam(value = "pwd")String pwd,
			           //@RequestParam(value = "pwd")int pwd, // 타입을 정수형으로 변경 가능
			             @RequestParam(value = "pwd", defaultValue = "111")int pwd, Model model) { // defaultValue 사용 : 디폴트값 설정 가능
		String data = "";
		if(id.equals("user") && pwd == 111) {
			data = "로그인 성공";
		} else { 
			data = "로그인 실패";
		}
		
		model.addAttribute("data", data);
		return "result";
	}
	
	
	
}
