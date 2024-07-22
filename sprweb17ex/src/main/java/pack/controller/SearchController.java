package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Jikwon;
import pack.model.JikwonDao;

@Controller
public class SearchController {
	
	@Autowired
	private JikwonDao dao;
	
	@RequestMapping(value = "search")
	public String search() {
		return "search";
	}
	
	@RequestMapping(value = "jikwon")
	public String result(@RequestParam("searchName")String buser_num, @RequestParam("grade")String jikwon_rating, Model model) {
		ArrayList<Jikwon> slist = (ArrayList<Jikwon>)dao.search(buser_num, jikwon_rating);
		System.out.println(jikwon_rating);
		model.addAttribute("list", slist);
		return "result";
	}
}
