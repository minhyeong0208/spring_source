package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;

//@Controller
//@ResponseBody  // 응답을 하는데, json으로 응답을 하겠다는 의미. 
@RestController // @RestController = @Controller + @ResponseBody -> 비동기 처리에서 사용
//이 어노테이션 사용한다는 의미는 restful 프로그램이며, 비동기 처리에서 사용
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	/*
//	@GetMapping("/members")
//	public String list(Model model) {
//		List<MemberDto> list= dao.getList();
//		model.addAttribute("list", list);
//		return "list";
//	}
	
	
//	@GetMapping("/members")
//	public String list(Model model) {
//		
//		return "나이스";  // 반환 타입을 String으로 한 경우, html로 넘긴 것이 아니라 문자열을 클라이언트로 반환함.
//	}
	
	@GetMapping("/members")
	public MemberDto list(Model model) {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("공기밥");
		dto.setAddr("강남구 역삼동");
		
		return dto;
	}
	
	@GetMapping("/insertform")
	public String insertform() {
		return "insertform";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam("name")String name, @RequestParam("addr")String addr) {  // DTO로 받을 수도 있다.
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		dao.insert(dto);
		
		return "redirect:/members"; // redirect 방식 : 추가 후 목록보기
	}
	*/
	
	// -----------------REST 요청 처리 -------------------
	
	// 자바스크립트로 전달하기 위해(React 사용)
	@GetMapping("/members")  // 전체 자료 읽기
	public List<MemberDto> getList() {
		// DB 자료를 읽어
		// HTML로 반환하는 것이 아닌 JSON 형태로 변환해 클라이언트(JS AJAX 요청)에 반환
		System.out.println("get 요청!");
		return dao.getList();  // ResponseBody가 JSON 형태로 반환시켜준다.
	}
	
	@PostMapping("/members")  // 자료 추가
	public Map<String, Object> insert(@RequestBody MemberDto dto) {
		// @RequestBody : 요청 본문에 담긴 값(JSON)을 자바 객체로 변환
		dao.insert(dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);  // JSON 형태로 리턴
		return map;
	}
	
	@GetMapping("/members/{num}")  // http://localhost:80/members/3
	public MemberDto getData(@PathVariable("num")int num) {
		// DB 자료를 읽어
		// HTML로 반환하는 것이 아닌 JSON 형태로 변환해 클라이언트(JS AJAX 요청)에 반환
		return dao.getData(num);
	}
	
	@PutMapping("/members/{num}")
	public Map<String, Object> update(@PathVariable("num")int num, @RequestBody MemberDto dto) {
		dto.setNum(num);
		dao.update(dto);
		
		return Map.of("isSuccess", true);
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num")int num) {
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
	
}
