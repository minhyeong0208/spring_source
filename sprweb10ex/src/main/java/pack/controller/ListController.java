package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import pack.model.DataDao;
import pack.model.JikwonDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListController {
	
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("jikwondb")
	public String listProcess(@RequestParam(value="jik")String jik , Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.selectJikList(jik);
		model.addAttribute("datas", list);
	
		return "show";
	}
	
}
