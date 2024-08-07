package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.repo.JikwonRepository;

@CrossOrigin("*")
@RestController
public class TestController {
	
	@Autowired
	private JikwonRepository repo;
	
	@GetMapping("/jikwons/{jik}")
	public List<JikwonDto> list(@PathVariable("jik")String jik) {
		List<JikwonDto> jlist = repo.findByJik(jik)
									.stream()
									.map(JikwonDto::toDto)
									.toList();
		return jlist;
	}
}
