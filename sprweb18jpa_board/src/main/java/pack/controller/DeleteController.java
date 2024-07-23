package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDao;

@Controller
public class DeleteController {
	@Autowired
	private BoardDao dao;
	
	@GetMapping("delete")
	public String updateSubmit(@RequestParam("num") int num, Model model) {
		String str = dao.deleteData(num);
		
		if(str.equals("success")) {  // 추가 후, 목록보기
			return "redirect:/list";
		} else {
			model.addAttribute("msg", str);
			return "error";			
		}
	}
	
}