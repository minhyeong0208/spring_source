package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.SangpumDto;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("testdao")
	public String listProcess(Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataAll();
		model.addAttribute("datas", list);
	
		return "list";
	}
	
}
