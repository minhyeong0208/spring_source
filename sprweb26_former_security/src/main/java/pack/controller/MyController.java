package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name = "userid")String userid
			, @RequestParam(name = "password")String password
			, HttpSession session, Model model) {
		String validId = "ok";
		String validPassword = "123";
		
		if(userid.equals(validId) && password.equals(validPassword)) {
			session.setAttribute("user", userid);
			return "redirect:/success";
		} else {
			model.addAttribute("error", "잘못된 ID 또는 PW 입니다.");
			return "login";
		}
	}
	
	@GetMapping("/success")
	public String success(HttpSession session, Model model) {
		String user = (String)session.getAttribute("user"); // key 값이 user인 경우
		
		if(user != null) {
			model.addAttribute("myuser", user);
			return "success";			
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.invalidate();
		session.removeAttribute("user");
		return "redirect:/login";
	}
	
	@GetMapping("/gugu")
	public String gugu(HttpSession session) {
		if(session.getAttribute("user") != null) {
			return "gugu";
		} else {
			return "redirect:/login";
		}
	}
	
	@PostMapping("/auth/gugu")
	public String gugu(@RequestParam("num")int num, HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			model.addAttribute("num", num);
			return "guguresult";
		} else {
			return "redirect:/login";
		}
	}
	
	
}
