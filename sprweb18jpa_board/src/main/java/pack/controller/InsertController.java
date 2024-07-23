package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.BoardDao;

@Controller
public class InsertController {
	@Autowired
	private BoardDao dao;
	
	@GetMapping("insert")
	public String insert() {
		return "insertForm";
	}
	
	@PostMapping("insert")
	public String insertSubmit(BoardBean bean, Model model) {
		String str = dao.insertData(bean);
		
		if(str.equals("success")) {  // 추가 후, 목록보기
			return "redirect:/list";
		} else {
			model.addAttribute("msg", str);
			return "error";			
		}
	}
	
}
