package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;
import pack.model.SangpumDto;

@Controller
public class ListController {

	@Autowired
	private DataDao dataDao;
	
	@GetMapping("mybatis")
	public String selectAll(Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataAll();
		model.addAttribute("datas", list);
		
		//데이터 하나 추출
		//SangpumDto dto = dataDao.getData("5");
		//model.addAttribute("dto", dto);
		
		return "list";
	}
	
	@GetMapping("search")
	public String search(FormBean bean, Model model) {
		ArrayList<SangpumDto> list = (ArrayList<SangpumDto>)dataDao.getDataSearch(bean);
		model.addAttribute("datas", list);

		return "list";
	}
}
