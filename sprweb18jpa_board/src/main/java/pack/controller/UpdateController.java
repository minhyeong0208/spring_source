package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDao;

@Controller
public class UpdateController {
	@Autowired
	private BoardDao dao;
	
	@PostMapping("update")
	public String updateSubmit(BoardBean bean, Model model) {
		String str = dao.updateData(bean);
		
		if(str.equals("success")) {  // 추가 후, 목록보기
			return "redirect:/list";
		} else {
			model.addAttribute("msg", str);
			return "error";			
		}
	}
	
}