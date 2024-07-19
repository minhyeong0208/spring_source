package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class TestController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")
	public String index() {
		return "index15";
	}
	
	@GetMapping("jikwondb")
	public String search(@RequestParam("jik")String jik, Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>)dataDao.getDataSearch(jik);
		model.addAttribute("datas", list);

		return "show";
	}
	
	@GetMapping("price")
	public String method(@RequestParam("name")String name,@RequestParam("price")int price, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("price", price);
		if(price >= 50000) {
			model.addAttribute("res", "고가");
		} else {
			model.addAttribute("res", "저가");
		}

		return "list";
	}
}
