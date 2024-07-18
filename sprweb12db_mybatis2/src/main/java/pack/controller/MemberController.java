package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataProcess;
import pack.model.MemberDto;


@Controller
public class MemberController {
	@Autowired
	private DataProcess dataProcess;  // Model
	
	@GetMapping("/")
	public String start() {
		return "start";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<MemberDto> list = (ArrayList<MemberDto>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert(Model model) {
		return "insert";
	}
	
	@PostMapping("insert")
	public String insertProcess(MemberBean bean) {
		boolean b = dataProcess.insert(bean);
		
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	
	@GetMapping("update")
	public String update(@RequestParam("num")String num, Model model) {
		MemberDto dto = dataProcess.getData(num);
		model.addAttribute("data", dto);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemberBean bean) {
		boolean b = dataProcess.update(bean);
		
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("num")String num) {
		boolean b = dataProcess.delete(num);
		
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";
	}
}
