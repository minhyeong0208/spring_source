package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/mlist")
	public String memberList(Model model) {
		// 멤버에 대한 작업을 수행...
		mService.getList(model);  
		// MemberController에서 리턴을 하지 않았음에도 model을 받아온 이유?
		// Model 객체는 스프링이 제공하는 모델을 사용하는 것이므로 따로 반환을 해주지 않아도 된다.
		// getList 내부에서 model.addAttribute를 통해 데이터를 모델에 추가하고 있기 때문.
		return "member/mlist";
	}
	
	// 자료 추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) {
		// 멤버에 대한 작업을 수행...
		mService.insert(fbean);  
		// MemberController에서 리턴을 하지 않았음에도 model을 받아온 이유?
		// Model 객체는 스프링이 제공하는 모델을 사용하는 것이므로 따로 반환을 해주지 않아도 된다.
		
		return "member/insert";
	}
	
	// 회원자료 수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num, Model model) {
		mService.getData(num, model);
		
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		mService.update(fbean);  

		return "member/update";
	}
	
	// 회원자료 삭제
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mService.delete(num);
			
		return "redirect:/member/mlist";
	}
}
