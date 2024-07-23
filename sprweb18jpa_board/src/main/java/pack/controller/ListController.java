package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.Board;
import pack.model.BoardDao;

@Controller
public class ListController {
	@Autowired
	private BoardDao dao;
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Board> list = (ArrayList<Board>)dao.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@PostMapping("search")
	public String search(BoardBean bean, Model model) {
		ArrayList<Board> slist = (ArrayList<Board>)dao.search(bean);
		model.addAttribute("list", slist);
		
		return "list";
	}
}