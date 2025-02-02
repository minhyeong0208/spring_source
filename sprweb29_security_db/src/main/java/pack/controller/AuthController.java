package pack.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	// 인증 처리를 위해 AuthenticationManager 객체를 필드로 선언. 로그인 인증을 처리 담당
	private final AuthenticationManager authenticationManager;
	
	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@GetMapping("/")
	public String sijak() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("sabun")String sabun, @RequestParam("irum")String irum, Model model) {
		
		try {
			// 사원번호와 이름으로 인증 토큰 생성
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sabun, irum);
			
			// AuthenticationManager를 통해 인증 시도
			Authentication authentication = authenticationManager.authenticate(token);

			// 인증 성공 시, SecurityContextHolder에 인증 객체를 저장 
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return "redirect:/auth/success";  // 성공 시, 넘어갈 페이지
			
		} catch (AuthenticationException e) {
			model.addAttribute("error", "");
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  // 47행에서 담아놓은 인증 정보(username,password)를 가져옴
		
		String username = authentication.getName();
		model.addAttribute("username", username);
		
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/auth/login";
	}
	
	@GetMapping("/gugu")
	public String gugu() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || !authentication.isAuthenticated()) { 
			return "redirect:/auth/login";
		}
		return "gugu";
	}
	
	@PostMapping("/gugu")
	public String guguresult(@RequestParam("num")int num, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || !authentication.isAuthenticated()) { 
			return "redirect:/auth/login";
		}
		model.addAttribute("num", num);
		return "guguresult";
	}
}
