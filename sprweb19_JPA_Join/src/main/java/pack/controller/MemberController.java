package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDTO;
import pack.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
	
	// 자료 읽기
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mservice.getList(model);
		
		return "member/mlist";
	}
	
	
	// 추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDTO fbean) {
		mservice.insert(fbean);
		
		return "member/insert";
	}
	
	
	// 회원 수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num, Model model) {
		mservice.getData(num, model);
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDTO fbean) {
		//mservice.update(fbean);
		mservice.update2(fbean);
		
		return "member/update";
	}
	
	// 삭제
	@GetMapping("/member/delete")
	public String delete(@RequestParam("num") Long num) {
		mservice.delete(num);
		return "redirect:/member/mlist";
	}
}
