package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String result(JikwonBean bean, Model model) {
		ArrayList<Jikwon> slist = null;
		if(!bean.getJikwon_rating().equals("all")) {
			slist = (ArrayList<Jikwon>)dao.search(bean);
		} else {
			slist = (ArrayList<Jikwon>)dao.selectAll();
		}
		

		model.addAttribute("list", slist);
		return "result";
	}
	
}
