package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.repo.JikwonDao;

@CrossOrigin("*")
@RestController
public class JikwonController {
	
	@Autowired
	private JikwonDao dao;
	
	@GetMapping("/jikwons/{buser_name}")
	public List<JikwonDto> list(@PathVariable("buser_name")String bname) {
		return dao.getList(bname);
	}
	
}
