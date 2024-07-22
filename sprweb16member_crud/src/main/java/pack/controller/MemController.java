package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataProcess;
import pack.model.Mem;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemController {

	@Autowired
	private DataProcess dataProcess;

	@GetMapping("/")
	public String start() {
		return "start";
	}

	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>) dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}

	@GetMapping("insert")
	public String insert(Model model) {
		return "insert";
	}

	@PostMapping("insert")
	public String insertProcess(MemBean bean, Model model) {

		String msg = dataProcess.insert(bean);

		if (msg.equals("성공"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}

	@GetMapping("update")
	public String update(@RequestParam("num")String num, Model model) {  // Spring Boot 3.x의 경우, RequestParam 어노테이션이 필요.
		//System.out.println("num : " + num);
		Mem mem = dataProcess.getData(num);
		
		model.addAttribute("data", mem);
		return "update";
	}

	@PostMapping("update")
	public String updateProcess(MemBean bean, Model model) {
		String msg = dataProcess.update(bean);
		
		if(msg.equals("성공"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
	
	@GetMapping("delete")
	public String deleteProcess(@RequestParam("num")int num, Model model) {
		String msg = dataProcess.delete(num);
		
		if(msg.equals("성공"))
			return "redirect:/list";
		else {
			model.addAttribute("msg", msg);
			return "error";
		}
	}
}
