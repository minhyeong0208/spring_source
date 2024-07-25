package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.GogekRepository;
import pack.model.Jikwon;
import pack.model.JikwonRepository;

@Controller
public class JikwonController {
	
	@Autowired
	private JikwonRepository jikwonRepo;
	
	@Autowired 
	private GogekRepository gogekRepo;
	
	@GetMapping("jikwon/list")
	public String jikwonlist(Model model) {
		List<Jikwon> list = jikwonRepo.findAll();
		model.addAttribute("list", list);
		return "jikwon/list";
	}
}
