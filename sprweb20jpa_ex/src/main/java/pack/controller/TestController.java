package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.GogekDto;
import pack.dto.JikwonDto;
import pack.repository.GogekRepository;
import pack.repository.JikwonRepository;

@Controller
public class TestController {

	@Autowired
	private JikwonRepository jikwonRepo;
	
	@Autowired
	private GogekRepository gogekRepo;
	
	@GetMapping("/")
	public String jikwonlist(Model model) {
		List<JikwonDto> jlist = jikwonRepo.findAll()
										.stream()
										.map(JikwonDto::toDto)
										.toList();
		model.addAttribute("jlist", jlist);
		return "jikwonlist";
	}
	
	@GetMapping("/gogek")
	public String gogeklist(@RequestParam("jno")int jno, Model model) {
		JikwonDto dto = JikwonDto.toDto(jikwonRepo.findByJno(jno));		
		model.addAttribute("jikwon", dto);
		
		List<GogekDto> glist = gogekRepo.findByJikwonJno(jno)
										.stream()
										.map(GogekDto::toDto)
										.toList();
		model.addAttribute("glist", glist);
		model.addAttribute("size", glist.size());
		return "gogeklist";
	}
}
